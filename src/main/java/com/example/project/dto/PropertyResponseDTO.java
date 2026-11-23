package com.example.project.dto;

import com.example.project.enums.PropertyStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// DTO for property response data
@Getter
@Setter
public class PropertyResponseDTO {

    private Long id;

    private String title;

    private String description;

    private Double price;

    private String location;

    private String imageUrl;

    private boolean available;

    private PropertyStatus status;

    private LocalDate createdDate;
}