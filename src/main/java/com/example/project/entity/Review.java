package com.example.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This entity represents buyer reviews about agents
@Entity

// Automatically generate getter methods
@Getter

// Automatically generate setter methods
@Setter

// Automatically generate empty constructor
@NoArgsConstructor

// Database table name
@Table(name = "reviews")
public class Review {

    // Primary key
    @Id

    // Auto increment id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Review message
    @Column(nullable = false)
    private String comment;

    // Review rating
    private int rating;

    // Review hidden status
    private boolean hidden = false;

    // Buyer who created the review
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    // Agent who receives the review
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User agent;
}