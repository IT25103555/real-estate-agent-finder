package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

// DTO for review response data
@Getter
@Setter
public class ReviewResponseDTO {

    private Long id;

    private String comment;

    private int rating;

    private boolean hidden;
}