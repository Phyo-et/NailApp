package com.nailsalon.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentmethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private LocalDateTime paidAt;

    public enum PaymentMethod{
        CASH,
        CARD,
        KPAY,
        WAVEPAY
    }

    public enum PaymentStatus{
        PAID,
        PENDING,
        REFUNDED
    }


    //    private Long id;
    //
    //    @OneToOne
    //    @JoinColumn(name = "appointment_id")
    //    private Appointment appointment;
    //
    //    private BigDecimal amount;
    //
    //    @Enumerated(EnumType.STRING)
    //    private PaymentMethod paymentMethod;
    //
    //    @Enumerated(EnumType.STRING)
    //    private PaymentStatus paymentStatus;
    //
    //    private LocalDateTime paidAt;
    //
    //    private LocalDateTime createdAt;
    //
    //    private LocalDateTime updatedAt;
    //
    //    private Boolean delFlg;
    //}
}
