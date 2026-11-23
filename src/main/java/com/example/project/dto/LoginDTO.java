package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

// DTO for user login
@Getter
@Setter
public class LoginDTO {

    private String email;
    private String password;
}

