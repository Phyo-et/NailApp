package com.nailsalon.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private int id;
    private String name;
    private String phone;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    private int delflag =0;

    public enum Gender {
        MALE,
        FEMALE
    }

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
