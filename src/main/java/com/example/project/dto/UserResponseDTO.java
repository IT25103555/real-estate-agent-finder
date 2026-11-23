package com.example.project.dto;

import com.example.project.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// DTO for user response data
@Getter
@Setter
public class UserResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String contactNumber;

    private Role role;

    private LocalDate joinDate;
}