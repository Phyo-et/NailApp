package com.nailsalon.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    private LocalDate appointmentDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Status status;
    private String notes;
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
    public enum Status {
        BOOKED,
        COMPLETED,
        CANCELLED
    }
}