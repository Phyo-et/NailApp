package com.nailsalon.backend.repository;

import com.nailsalon.backend.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment , Integer> {


    List<Appointment> findByDelflag(int delflag);

}
