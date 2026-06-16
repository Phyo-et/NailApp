package com.nailsalon.backend.controller;

import com.nailsalon.backend.dto.NailServiceDTO;
import com.nailsalon.backend.service.NailServiceService;
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
@RequiredArgsConstructor
@RequestMapping("/services")
public class NailServiceController {
    private final NailServiceService service;

    @PostMapping
    public ResponseEntity<NailServiceDTO> create(@RequestBody NailServiceDTO dto){
        NailServiceDTO createdNailService = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNailService);
    }

    @GetMapping
    public ResponseEntity<List<NailServiceDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NailServiceDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NailServiceDTO> update (@PathVariable int id , @RequestBody NailServiceDTO dto){
        return ResponseEntity.ok(service.update(id , dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id ){
        service.delete(id);
        return ResponseEntity.ok("NailService id  ( "+service.getById(id).getName() + " ) is deleted successfully ");
    }

}
