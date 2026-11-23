package com.example.project.entity;

import com.example.project.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// This entity represents all users in the system
@Entity

// Automatically generate getter methods
@Getter

// Automatically generate setter methods
@Setter

// Automatically generate empty constructor
@NoArgsConstructor

// Database table name
@Table(name = "users")
public class User {

    // Primary key
    @Id

    // Auto increment id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User full name
    @Column(nullable = false)
    private String name;

    // User email address
    @Column(nullable = false, unique = true)
    private String email;

    // User password
    @Column(nullable = false)
    private String password;

    // User contact number
    @Column(nullable = false)
    private String contactNumber;

    // User role
    @Enumerated(EnumType.STRING)
    private Role role;

    // User account created date
    private LocalDate joinDate;
}