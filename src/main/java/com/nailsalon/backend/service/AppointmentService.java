package com.nailsalon.backend.service;

import com.nailsalon.backend.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO create( AppointmentDTO dto);

    List<AppointmentDTO> getAll();

    AppointmentDTO getById( int id);

    AppointmentDTO update( int id,AppointmentDTO dto);

    void delete( int id);
}
