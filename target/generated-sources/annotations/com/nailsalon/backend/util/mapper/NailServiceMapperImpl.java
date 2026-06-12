package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.NailService;
import com.nailsalon.backend.dto.NailServiceDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-12T13:43:07+0630",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
public class NailServiceMapperImpl implements NailServiceMapper {

    @Override
    public NailServiceDTO toDTO(NailService nailService) {
        if ( nailService == null ) {
            return null;
        }

        NailServiceDTO nailServiceDTO = new NailServiceDTO();

        nailServiceDTO.setName( nailService.getName() );
        nailServiceDTO.setDescription( nailService.getDescription() );
        nailServiceDTO.setPrice( nailService.getPrice() );
        nailServiceDTO.setDurationMinute( nailService.getDurationMinute() );

        return nailServiceDTO;
    }

    @Override
    public NailService toEntity(NailServiceDTO nailServiceDTO) {
        if ( nailServiceDTO == null ) {
            return null;
        }

        NailService nailService = new NailService();

        nailService.setName( nailServiceDTO.getName() );
        nailService.setDescription( nailServiceDTO.getDescription() );
        nailService.setPrice( nailServiceDTO.getPrice() );
        nailService.setDurationMinute( nailServiceDTO.getDurationMinute() );

        return nailService;
    }
}
