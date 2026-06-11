package com.nailsalon.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private String gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column()
    private int delflag =0;

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
