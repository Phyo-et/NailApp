package com.nailsalon.backend.dto;

import lombok.Data;

@Data
public class NailServiceDTO {
    private String name;
    private String description;
    private double price;
    private int durationMinute;
}
