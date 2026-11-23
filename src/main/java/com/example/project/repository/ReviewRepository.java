package com.example.project.repository;

import com.example.project.entity.Review;
import com.example.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// This repository handles database operations for reviews
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Find reviews using agent
    List<Review> findByAgent(User agent);
}