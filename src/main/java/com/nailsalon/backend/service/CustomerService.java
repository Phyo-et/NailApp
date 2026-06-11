package com.nailsalon.backend.service;

import com.nailsalon.backend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO create(CustomerDTO dto);

    List<CustomerDTO> getAll();

    CustomerDTO getById(int id);

    CustomerDTO update(int id, CustomerDTO dto);

    void delete(int id);


}
