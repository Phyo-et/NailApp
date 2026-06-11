package com.nailsalon.backend.service;

import com.nailsalon.backend.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    StaffDTO create(StaffDTO dto);

     List<StaffDTO> getAll();

     StaffDTO getById(int id);

        StaffDTO update(int id, StaffDTO dto);

        void delete(int id);
}
