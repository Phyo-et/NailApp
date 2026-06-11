package com.nailsalon.backend.controller;

import com.nailsalon.backend.dto.AppointmentDTO;
import com.nailsalon.backend.service.AppointmentService;
import lombok.RequiredArgsConstructor;
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
    public AppointmentDTO create (@RequestBody AppointmentDTO dto){
        return appointmentService.create(dto);
    }

    @GetMapping
    public List<AppointmentDTO> getAll(){
        return appointmentService.getAll();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getById (@PathVariable int id ){
        return appointmentService.getById(id);
    }

    @PutMapping("/{id}")
    public AppointmentDTO update (@PathVariable int id ,@RequestBody AppointmentDTO dto){
        return appointmentService.update(id , dto);
    }
    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id){
        appointmentService.delete(id);
        return "Appointment ( "+appointmentService.getById(id).getAppointmentDate() +" ) is deleted successfully ";
    }

}
