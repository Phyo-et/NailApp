package com.nailsalon.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "staffs")
public class Staff extends BaseEntity{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private int id;
    private String name;
    private String phone;
    private String role;
    private int experienceYears ;

}
