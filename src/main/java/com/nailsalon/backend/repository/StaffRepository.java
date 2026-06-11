package com.nailsalon.backend.repository;

import com.nailsalon.backend.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

    boolean existsByPhone(String phone);

    List<Staff> findByDelflag(int delflag);
}
