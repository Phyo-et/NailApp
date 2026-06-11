package com.nailsalon.backend.service.impl;

import com.nailsalon.backend.domain.Staff;
import com.nailsalon.backend.dto.StaffDTO;
import com.nailsalon.backend.exception.DuplicateResourceException;
import com.nailsalon.backend.exception.ResourceNotFoundException;
import com.nailsalon.backend.repository.StaffRepository;
import com.nailsalon.backend.service.StaffService;
import com.nailsalon.backend.util.mapper.StaffMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper= Mappers.getMapper(StaffMapper.class);

    @Override
    public StaffDTO create(StaffDTO dto) {
        if (staffRepository.existsByPhone(dto.getPhone())){
            log.warn("Staff phone number can't be same");
            throw new DuplicateResourceException(dto.getPhone() + " already exists");
        }
        Staff staff = staffMapper.toEntity(dto);
        log.info("Staff is created");

        return staffMapper.toDTO(staffRepository.save(staff));
    }

    @Override
    public List<StaffDTO> getAll() {
        log.info("Active Staff List is searched");
        return staffRepository.findByDelflag(0)
                .stream()
                .map(staffMapper::toDTO)
                .toList();
    }

    @Override
    public StaffDTO getById(int id) {
        Staff staff= staffRepository.getById(id);
        if (staff == null){
            log.warn("Staff not Found");
            new ResourceNotFoundException("Staff not Found");
        }
        StaffDTO dto = staffMapper.toDTO(staff);
        log.info("Staff is found");
        return dto;
    }

    @Override
    public StaffDTO update(int id, StaffDTO dto) {
        Staff staff= staffRepository.getById(id);
        if (staff == null){
            log.warn("Staff not Found");
            new ResourceNotFoundException("Staff not Found");
        }
        staff.setName( dto.getName() );
        staff.setPhone( dto.getPhone() );
        staff.setRole( dto.getRole() );
        staff.setExperienceYears( dto.getExperienceYears() );

        Staff updatedStaff = staffRepository.save(staff);
        log.info("Staff  id "+id + " is  updated");
        return staffMapper.toDTO(updatedStaff);
    }

    @Override
    public void delete(int id) {
        Staff staff= staffRepository.getById(id);
        if (staff == null){
            log.warn("Staff not Found");
            new ResourceNotFoundException("Staff not Found");
        }
        staff.setDelflag(1);
        staffRepository.save(staff);
        log.info("Staff id "+id + " is deleted !!!");

    }
}
