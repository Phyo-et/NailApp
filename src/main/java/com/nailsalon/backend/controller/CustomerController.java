package com.nailsalon.backend.controller;

import com.nailsalon.backend.dto.CustomerDTO;
import com.nailsalon.backend.service.CustomerService;
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
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerDTO create ( @RequestBody CustomerDTO dto){
        return customerService.create(dto);
    }

    @GetMapping
    public List<CustomerDTO> getAll(){
        return  customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getById( @PathVariable int id ){
        return customerService.getById(id);
    }

    @PutMapping("/{id}")
    public CustomerDTO update( @PathVariable int id , @RequestBody CustomerDTO dto){
        return customerService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public String delete ( @PathVariable int id){
        customerService.delete(id);
        return "Customer ( "+customerService.getById(id).getCustomerName() + " ) is deleted successfully ";
    }


}
