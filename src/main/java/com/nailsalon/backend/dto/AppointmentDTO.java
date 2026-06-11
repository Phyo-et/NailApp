package com.nailsalon.backend.dto;

import lombok.Data;

@Data
public class AppointmentDTO {

    private int customerId;
    private int staffId;
    private String appointmentDate;
    private String startTime;
    private String endTime;
    private String status;
    private String notes;
}
