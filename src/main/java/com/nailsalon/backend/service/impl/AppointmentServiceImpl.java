package com.nailsalon.backend.service.impl;

import com.nailsalon.backend.domain.Appointment;
import com.nailsalon.backend.domain.Customer;
import com.nailsalon.backend.domain.Staff;
import com.nailsalon.backend.dto.AppointmentDTO;
import com.nailsalon.backend.exception.ResourceNotFoundException;
import com.nailsalon.backend.repository.AppointmentRepository;
import com.nailsalon.backend.repository.CustomerRepository;
import com.nailsalon.backend.repository.StaffRepository;
import com.nailsalon.backend.service.AppointmentService;
import com.nailsalon.backend.util.mapper.AppointmentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper = Mappers.getMapper(AppointmentMapper.class);
    private final CustomerRepository customerRepository;
    private final StaffRepository staffRepository;

    @Override
    public AppointmentDTO create(AppointmentDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        if (customer.getDelflag() == 1 ) {
            throw new ResourceNotFoundException("Customer is deleted");
        }

        Staff staff = staffRepository.findById(dto.getStaffId()).orElseThrow(() -> new ResourceNotFoundException("Staff not found"));
        if (staff.getDelflag() == 1) {
            throw new ResourceNotFoundException("Staff is deleted");
        }
        Appointment appointment = appointmentMapper.toEntity(dto);
        log.info("Created Appointment");
        return appointmentMapper.toDTO(appointmentRepository.save(appointment));
    }

    @Override
    public List<AppointmentDTO> getAll() {
        log.info("Appointment List is searched");
        return appointmentRepository.findByDelflag(0)
                .stream()
                .map(appointmentMapper::toDTO)
                .toList();
    }

    @Override
    public AppointmentDTO getById(int id) {
        Appointment appointment= appointmentRepository.getById(id);
        if ( appointment == null ) {
            log.warn("Appointment is not found");
            throw new ResourceNotFoundException("Appointment not found ");
        }
        log.info("Appointment is searched");
        return appointmentMapper.toDTO(appointment);
    }

    @Override
    public AppointmentDTO update(int id, AppointmentDTO dto) {
        Appointment appointment= appointmentRepository.getById(id);
        if ( appointment == null ) {
            log.warn("Appointment is not found");
            throw new ResourceNotFoundException("Appointment not found ");
        }
        Customer customer = customerRepository.findById(dto.getCustomerId()).orElseThrow(() ->new ResourceNotFoundException("Customer not found"));

        if (customer.getDelflag()== 1){
            throw new ResourceNotFoundException("Customer is not found");
        }
        appointment.setCustomer(customer);

        Staff staff= staffRepository.findById(dto.getStaffId()).orElseThrow(()->new ResourceNotFoundException("Staff not found"));
        staff.setId(dto.getStaffId());
        if (staff.getDelflag()== 1){
            throw new ResourceNotFoundException("Staff is not found");
        }
        appointment.setStaff(staff);


        appointment.setAppointmentDate(LocalDate.parse(dto.getAppointmentDate()));
        appointment.setStartTime(LocalTime.parse(dto.getStartTime()));
        appointment.setEndTime(LocalTime.parse(dto.getEndTime()));

        appointment.setStatus(Appointment.Status.valueOf(dto.getStatus()));
        appointment.setNotes(dto.getNotes());

        Appointment updatedAppointment = appointmentRepository.save(appointment);

        log.info("Appointment is updated");
        return appointmentMapper.toDTO(updatedAppointment);
    }

    @Override
    public void delete(int id) {
        Appointment appointment= appointmentRepository.getById(id);
        if ( appointment == null ) {
            log.warn("Appointment is not found");
            throw new ResourceNotFoundException("Appointment not found ");
        }
        appointment.setDelflag(1);
        appointmentRepository.save(appointment);
        log.info("Appointment id "+id + " is deleted");
    }
}
