package com.nailsalon.backend.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String customerName;
    private String phone;
    private String email;
    private String gender;
}
