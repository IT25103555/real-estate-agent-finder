package com.example.project.controller;

import com.example.project.entity.Review;
import com.example.project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// This controller handles review APIs
@RestController

// Base URL for review APIs
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Create new review
    @PostMapping
    public Review createReview(@RequestBody Review review) {

        return reviewService.saveReview(review);
    }

    // Get all reviews
    @GetMapping
    public List<Review> getAllReviews() {

        return reviewService.getAllReviews();
    }

    // Get review using id
    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable Long id) {

        return reviewService.getReviewById(id);
    }

    // Delete review using id
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {

        reviewService.deleteReview(id);

        return "Review deleted successfully";
    }
}