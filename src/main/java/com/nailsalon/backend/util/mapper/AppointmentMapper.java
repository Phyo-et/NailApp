package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.Appointment;
import com.nailsalon.backend.domain.Customer;
import com.nailsalon.backend.domain.Staff;
import com.nailsalon.backend.dto.AppointmentDTO;
import com.nailsalon.backend.exception.ResourceNotFoundException;
import com.nailsalon.backend.service.StaffService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring",
uses = {CustomerMapper.class, StaffMapper.class})
public interface AppointmentMapper {

    @Mapping(target = "customerId", source = "customer")
    @Mapping(target = "staffId",source = "staff")
    AppointmentDTO toDTO (Appointment appointment);

    @Mapping(target = "customer", source = "customerId")
    @Mapping(target = "staff", source = "staffId")
    Appointment toEntity(AppointmentDTO appointmentDTO);

    default Customer mapCustomer(int id) {
        Customer customer = new Customer();
        customer.setId(id);
        if (customer.getDelflag()== 1){
             throw new ResourceNotFoundException("Customer is not found");
        }
        return customer;

    }

    default Staff mapStaff(int id) {
        Staff staff = new Staff();
        staff.setId(id);
        if (staff.getDelflag()!= 0){
            throw new ResourceNotFoundException("Staff is not found");
        }
        return staff;

    }

    default int mapCustomer(Customer customer) {
        return customer != null ? customer.getId() : 0;
    }

    default int mapStaff(Staff staff) {
        return staff != null ? staff.getId() : 0;
    }

}
