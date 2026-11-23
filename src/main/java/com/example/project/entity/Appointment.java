package com.example.project.entity;

import com.example.project.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

// This entity represents buyer appointments
@Entity

// Automatically generate getter methods
@Getter

// Automatically generate setter methods
@Setter

// Automatically generate empty constructor
@NoArgsConstructor

// Database table name
@Table(name = "appointments")
public class Appointment {

    // Primary key
    @Id

    // Auto increment id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Buyer contact number
    @Column(nullable = false)
    private String contactNumber;

    // Appointment date
    private LocalDate date;

    // Appointment time
    private LocalTime time;

    // Appointment request status
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

	// Buyer who created appointment
	@ManyToOne
	@JoinColumn(name = "buyer_id", nullable = true)
	private User buyer;

	// Agent who receives appointment
	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = true)
	private User agent;

	// Property related to appointment
	@ManyToOne
	@JoinColumn(name = "property_id", nullable = true)
	private Property property;
}