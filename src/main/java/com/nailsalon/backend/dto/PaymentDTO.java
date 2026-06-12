package com.nailsalon.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDTO {

    private int appointmentId;
    private String paymentmethod;
    private String paymentStatus;
    private LocalDateTime paidAt;


}
