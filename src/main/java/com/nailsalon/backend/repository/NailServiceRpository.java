package com.nailsalon.backend.repository;

import com.nailsalon.backend.domain.NailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NailServiceRpository extends JpaRepository<NailService,Integer> {

    List<NailService> findByDelflag (int delflag);
}
