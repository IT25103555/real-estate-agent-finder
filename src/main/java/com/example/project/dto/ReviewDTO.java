package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

// DTO for review request data
@Getter
@Setter
public class ReviewDTO {

    private String comment;

    private int rating;
}