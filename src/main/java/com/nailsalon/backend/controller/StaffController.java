package com.nailsalon.backend.controller;

import com.nailsalon.backend.dto.StaffDTO;
import com.nailsalon.backend.service.StaffService;
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
@RequestMapping("/staffs")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<StaffDTO> create (@RequestBody StaffDTO dto){
        StaffDTO createdStaff = staffService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStaff);
    }

    @GetMapping
    public ResponseEntity<List<StaffDTO>> getAll(){
        return ResponseEntity.ok(staffService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(staffService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffDTO> update (@PathVariable int id, @RequestBody StaffDTO dto){
        return ResponseEntity.ok(staffService.update(id , dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        staffService.delete(id);
        return ResponseEntity.ok("Staff ( "+ staffService.getById(id).getName()+" ) is deleted successfully ");
    }
}
