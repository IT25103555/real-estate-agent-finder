package com.example.project.entity;

import com.example.project.enums.PropertyStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// This entity represents properties in the system
@Entity

// Automatically generate getter methods
@Getter

// Automatically generate setter methods
@Setter

// Automatically generate empty constructor
@NoArgsConstructor

// Database table name
@Table(name = "properties")
public class Property {

    // Primary key
    @Id

    // Auto increment id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Property title
    @Column(nullable = false)
    private String title;

    // Property description
    @Column(nullable = false, length = 1000)
    private String description;

    // Property price
    @Column(nullable = false)
    private Double price;

    // Property location
    @Column(nullable = false)
    private String location;

    // Property image url
    private String imageUrl;

    // Property availability status
    private boolean available = true;

    // Property approval status
    @Enumerated(EnumType.STRING)
    private PropertyStatus status;

    // Property created date
    private LocalDate createdDate;

    // Seller who created the property
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    // Agent assigned to this property
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User agent;
}
