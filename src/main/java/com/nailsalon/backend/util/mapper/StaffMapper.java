package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.Staff;
import com.nailsalon.backend.dto.StaffDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    StaffDTO toDTO (Staff staff);

    Staff toEntity(StaffDTO staffDTO);

}
