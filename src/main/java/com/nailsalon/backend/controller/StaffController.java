package com.nailsalon.backend.controller;

import com.nailsalon.backend.dto.StaffDTO;
import com.nailsalon.backend.service.StaffService;
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
@RequestMapping("/staffs")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping
    public StaffDTO create (@RequestBody StaffDTO dto){
        return staffService.create(dto);
    }

    @GetMapping
    public List<StaffDTO> getAll(){
        return staffService.getAll();
    }

    @GetMapping("/{id}")
    public StaffDTO getById(@PathVariable int id){
        return staffService.getById(id);
    }

    @PutMapping("/{id}")
    public StaffDTO update (@PathVariable int id, @RequestBody StaffDTO dto){
        return staffService.update(id , dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        staffService.delete(id);
        return "Staff ( "+ staffService.getById(id).getName()+" ) is deleted successfully ";
    }
}
