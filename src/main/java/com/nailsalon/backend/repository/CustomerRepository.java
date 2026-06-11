package com.nailsalon.backend.repository;

import com.nailsalon.backend.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByDelflag(int delflag);
    boolean existsByPhone(String phone);
}
