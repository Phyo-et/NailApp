package com.nailsalon.backend.service;

import com.nailsalon.backend.dto.NailServiceDTO;

import java.util.List;

public interface NailServiceService {
    NailServiceDTO create (NailServiceDTO dto);

    List<NailServiceDTO> getAll();

    NailServiceDTO getById(int id);

    NailServiceDTO update(int id , NailServiceDTO request);

    void delete(int id);
}
