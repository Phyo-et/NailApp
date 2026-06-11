package com.nailsalon.backend.service.impl;

import com.nailsalon.backend.domain.NailService;
import com.nailsalon.backend.dto.NailServiceDTO;
import com.nailsalon.backend.exception.ResourceNotFoundException;
import com.nailsalon.backend.repository.NailServiceRpository;
import com.nailsalon.backend.service.NailServiceService;
import com.nailsalon.backend.util.mapper.NailServiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NailServiceServiceImpl implements NailServiceService {
    private final NailServiceRpository nailServiceRpository;
    private final NailServiceMapper nailServiceMapper = Mappers.getMapper(NailServiceMapper.class);

    @Override
    public NailServiceDTO create(NailServiceDTO dto) {
        NailService nailService = nailServiceMapper.toEntity(dto);
        log.info("NailService Added");
        return nailServiceMapper.toDTO(nailServiceRpository.save(nailService));
    }

    @Override
    public List<NailServiceDTO> getAll() {
        log.info("NailService list is searched");
        return  nailServiceRpository.findByDelflag(0)
                .stream()
                .map(nailServiceMapper::toDTO)
                .toList();
    }

    @Override
    public NailServiceDTO getById(int id) {
        NailService nailService = nailServiceRpository.getById(id);
        if (nailService == null){
            log.warn("nailService is not found !!!");
            throw new ResourceNotFoundException("NailService not found");
        }
        NailServiceDTO dto = nailServiceMapper.toDTO(nailService);
        log.info("NailService is found");
        return dto;
    }

    @Override
    public NailServiceDTO update(int id, NailServiceDTO dto) {
        NailService nailService = nailServiceRpository.getById(id);
        if (nailService == null){
            log.warn("nailService is not found !!!");
            throw new ResourceNotFoundException("NailService not found");
        }
        nailService.setName( dto.getName() );
        nailService.setDescription( dto.getDescription() );
        nailService.setPrice( dto.getPrice() );
        nailService.setDurationMinute( dto.getDurationMinute() );

        NailService updatedNailService = nailServiceRpository.save(nailService);
        log.info("NailService is updated");
        return nailServiceMapper.toDTO(updatedNailService);
    }

    @Override
    public void delete(int id) {
        NailService nailService = nailServiceRpository.getById(id);
        if (nailService == null){
            log.warn("nailService is not found !!!");
            throw new ResourceNotFoundException("NailService not found");
        }
        nailService.setDelflag(1);
        nailServiceRpository.save(nailService);
        log.info("NailService id "+id + " is deleted !!!");
    }
}
