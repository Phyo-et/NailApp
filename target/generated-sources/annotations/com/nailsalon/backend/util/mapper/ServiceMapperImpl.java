package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.Service;
import com.nailsalon.backend.dto.ServiceDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-01T12:45:57+0630",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public ServiceDTO toDTO(Service service) {
        if ( service == null ) {
            return null;
        }

        ServiceDTO serviceDTO = new ServiceDTO();

        serviceDTO.setName( service.getName() );
        serviceDTO.setDescription( service.getDescription() );
        serviceDTO.setPrice( service.getPrice() );
        serviceDTO.setDurationMinute( service.getDurationMinute() );

        return serviceDTO;
    }

    @Override
    public Service toEntity(ServiceDTO serviceDTO) {
        if ( serviceDTO == null ) {
            return null;
        }

        Service service = new Service();

        service.setName( serviceDTO.getName() );
        service.setDescription( serviceDTO.getDescription() );
        service.setPrice( serviceDTO.getPrice() );
        service.setDurationMinute( serviceDTO.getDurationMinute() );

        return service;
    }
}
