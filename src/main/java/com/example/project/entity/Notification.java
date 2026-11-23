package com.example.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// This entity represents notifications sent to users
@Entity

// Automatically generate getter methods
@Getter

// Automatically generate setter methods
@Setter

// Automatically generate empty constructor
@NoArgsConstructor

// Database table name
@Table(name = "notifications")
public class Notification {

	// Primary key
	@Id

	// Auto increment id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Notification message
	@Column(nullable = false)
	private String message;

	// Property involved in the notification
	@ManyToOne
	@JoinColumn(name = "property_id", nullable = false)
	private Property property;

	// Seller who receives the notification
	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private User seller;

	// Whether notification has been read
	private boolean isRead = false;

	// Date notification was created
	private LocalDate createdDate;
}

