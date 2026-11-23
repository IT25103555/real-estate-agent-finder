package com.example.project.service;

import com.example.project.entity.Review;
import com.example.project.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This service handles review business logic
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Save new review
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get review using id
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    // Delete review using id
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}