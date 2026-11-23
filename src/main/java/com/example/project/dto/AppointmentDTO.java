package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

// DTO for appointment request data
@Getter
@Setter
public class AppointmentDTO {

    private String contactNumber;

    private LocalDate date;

    private LocalTime time;

    private Long propertyId;
}