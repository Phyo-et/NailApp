package com.nailsalon.backend.service.impl;

import com.nailsalon.backend.domain.Customer;
import com.nailsalon.backend.dto.CustomerDTO;
import com.nailsalon.backend.exception.DuplicateResourceException;
import com.nailsalon.backend.exception.ResourceNotFoundException;
import com.nailsalon.backend.repository.CustomerRepository;
import com.nailsalon.backend.service.CustomerService;
import com.nailsalon.backend.util.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Override
    public CustomerDTO create(CustomerDTO dto) {
        if (customerRepository.existsByPhone(dto.getPhone())) {
            log.warn("Customer phone number can't be same");
            throw new DuplicateResourceException( dto.getPhone() + " already exists"
            );
        }
        Customer customer = customerMapper.toEntity(dto);
        log.info("Customer is created");

        return customerMapper.toDTO(customerRepository.save(customer));
    }

    @Override
    public List<CustomerDTO> getAll() {
        log.info("Active Customer list is searched");
        return customerRepository.findByDelflag(0)
                .stream()
                .map(customerMapper::toDTO)
                .toList();
    }

    @Override
    public CustomerDTO getById(int id) {
        Customer customer = customerRepository.getById(id);
        if (customer == null) {
            log.warn("Customer not found!");
            throw new ResourceNotFoundException("Customer not found");
        }
        CustomerDTO dto = customerMapper.toDTO(customer);
        log.info("Customer is found ");
        return dto;
    }

    @Override
    public CustomerDTO update(int id, CustomerDTO dto) {
        Customer customer = customerRepository.getById(id);
        if (customer == null) {
            log.warn("Customer not found!");
            throw new ResourceNotFoundException("Customer not found");
        }
        customer.setName( dto.getCustomerName() );
        customer.setPhone( dto.getPhone() );
        customer.setEmail( dto.getEmail() );
        customer.setGender( dto.getGender() );
        Customer updatedCustomer = customerRepository.save(customer);
        log.info("Customer id "+id + "is updated ");

        return customerMapper.toDTO(updatedCustomer);
    }

    @Override
    public void delete(int id) {
        Customer customer = customerRepository.getById(id);
        if (customer == null) {
            log.warn("Customer not found!");
            throw new ResourceNotFoundException("Customer not found");
        }
        customer.setDelflag(1);
        customerRepository.save(customer);
        log.info("customer id "+id + " is deleted !!!");
    }
}
