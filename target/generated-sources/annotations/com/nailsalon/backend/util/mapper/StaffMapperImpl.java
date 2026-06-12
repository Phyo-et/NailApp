package com.nailsalon.backend.util.mapper;

import com.nailsalon.backend.domain.Staff;
import com.nailsalon.backend.dto.StaffDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-12T13:43:07+0630",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class StaffMapperImpl implements StaffMapper {

    @Override
    public StaffDTO toDTO(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        StaffDTO staffDTO = new StaffDTO();

        staffDTO.setName( staff.getName() );
        staffDTO.setRole( staff.getRole() );
        staffDTO.setPhone( staff.getPhone() );
        staffDTO.setExperienceYears( staff.getExperienceYears() );

        return staffDTO;
    }

    @Override
    public Staff toEntity(StaffDTO staffDTO) {
        if ( staffDTO == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setName( staffDTO.getName() );
        staff.setPhone( staffDTO.getPhone() );
        staff.setRole( staffDTO.getRole() );
        staff.setExperienceYears( staffDTO.getExperienceYears() );

        return staff;
    }
}
