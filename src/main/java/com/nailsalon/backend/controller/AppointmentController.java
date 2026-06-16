package com.nailsalon.backend.controller;

import com.nailsalon.backend.dto.AppointmentDTO;
import com.nailsalon.backend.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;


    @PostMapping
    public ResponseEntity<AppointmentDTO> create (@RequestBody AppointmentDTO dto){
        AppointmentDTO createdAppointment = appointmentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAll(){
        return ResponseEntity.ok(appointmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getById (@PathVariable int id ){
        return ResponseEntity.ok(appointmentService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> update (@PathVariable int id ,@RequestBody AppointmentDTO dto){
        return ResponseEntity.ok(appointmentService.update(id , dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id){
        appointmentService.delete(id);
        return ResponseEntity.ok("Appointment ( "+appointmentService.getById(id).getAppointmentDate() +" ) is deleted successfully ");
    }

}
