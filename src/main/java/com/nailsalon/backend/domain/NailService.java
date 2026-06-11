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
@Table(name = "services")
public class NailService {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private int id;
    private String name;
    private String description;
    private double price;
    private int durationMinute;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int delflag=0;


    @PrePersist
    public void onCreate(){
        createdAt= LocalDateTime.now();
        updatedAt= LocalDateTime.now();
    }

    @PreUpdate
    public void  onUpdate(){
        updatedAt= LocalDateTime.now();
    }
}