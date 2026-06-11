package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.NailService;
import com.nailsalon.backend.dto.NailServiceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring ")
public interface NailServiceMapper {

    NailServiceDTO toDTO(NailService nailService);

    NailService toEntity(NailServiceDTO nailServiceDTO);
}
