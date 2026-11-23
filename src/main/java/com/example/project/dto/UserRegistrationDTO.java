package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

// DTO for user registration
@Getter
@Setter
public class UserRegistrationDTO {

    private String name;
    private String email;
    private String password;
    private String contactNumber;
}

