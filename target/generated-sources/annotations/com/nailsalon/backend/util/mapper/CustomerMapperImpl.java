package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.Customer;
import com.nailsalon.backend.dto.CustomerDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-15T13:50:20+0630",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerName( customer.getName() );
        customerDTO.setPhone( customer.getPhone() );
        customerDTO.setEmail( customer.getEmail() );
        if ( customer.getGender() != null ) {
            customerDTO.setGender( customer.getGender().name() );
        }

        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerDTO.getCustomerName() );
        customer.setPhone( customerDTO.getPhone() );
        customer.setEmail( customerDTO.getEmail() );
        if ( customerDTO.getGender() != null ) {
            customer.setGender( Enum.valueOf( Customer.Gender.class, customerDTO.getGender() ) );
        }

        return customer;
    }
}
