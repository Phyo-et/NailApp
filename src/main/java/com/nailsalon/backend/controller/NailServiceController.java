package com.nailsalon.backend.controller;

import com.nailsalon.backend.dto.NailServiceDTO;
import com.nailsalon.backend.service.NailServiceService;
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
@RequiredArgsConstructor
@RequestMapping("/services")
public class NailServiceController {
    private final NailServiceService service;

    @PostMapping
    public NailServiceDTO create(@RequestBody NailServiceDTO dto){
        return service.create(dto);
    }

    @GetMapping
    public List<NailServiceDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public NailServiceDTO getById(@PathVariable int id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public NailServiceDTO update (@PathVariable int id , @RequestBody NailServiceDTO dto){
        return service.update(id , dto);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id ){
        service.delete(id);
        return "NailService id  ( "+service.getById(id).getName() + " ) is deleted successfully ";
    }

}
