package com.example.project.dto;

import com.example.project.enums.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

// DTO for appointment response data
@Getter
@Setter
public class AppointmentResponseDTO {

    private Long id;

    private String contactNumber;

    private LocalDate date;

    private LocalTime time;

    private AppointmentStatus status;
}
