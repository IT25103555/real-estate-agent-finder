package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

// DTO for property request data
@Getter
@Setter
public class PropertyDTO {

    private String title;

    private String description;

    private Double price;

    private String location;

    private String imageUrl;
}