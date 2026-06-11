package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.Customer;
import com.nailsalon.backend.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper   {

    @Mapping(source = "name" , target = "customerName")
    CustomerDTO toDTO(Customer customer);

    @Mapping(source = "customerName",target = "name")
    Customer toEntity(CustomerDTO customerDTO);

}