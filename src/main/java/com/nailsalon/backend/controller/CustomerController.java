package com.nailsalon.backend.controller;

import com.nailsalon.backend.dto.CustomerDTO;
import com.nailsalon.backend.service.CustomerService;
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
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> create (@RequestBody CustomerDTO dto){
        CustomerDTO createdCustomer = customerService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll(){
        return  ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable int id ){
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update( @PathVariable int id , @RequestBody CustomerDTO dto){
        return ResponseEntity.ok(customerService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete ( @PathVariable int id){

        customerService.delete(id);

        return ResponseEntity.ok("Customer ( "+customerService.getById(id).getCustomerName() + " ) is deleted successfully ");
    }


}
