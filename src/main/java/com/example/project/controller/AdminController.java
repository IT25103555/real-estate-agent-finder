package com.example.project.controller;

import com.example.project.entity.Review;
import com.example.project.entity.User;
import com.example.project.enums.Role;
import com.example.project.service.ReviewService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// This controller handles admin APIs
@RestController

// Base URL for admin APIs
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    // Get all system users
    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    // Delete user using id
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully";
    }

    // Add new admin
    @PostMapping("/add-admin")
    public User addAdmin(@RequestBody User user) {

        user.setRole(Role.ADMIN);

        return userService.saveUser(user);
    }

    // Get all reviews
    @GetMapping("/reviews")
    public List<Review> getAllReviews() {

        return reviewService.getAllReviews();
    }

    // Delete review using id
    @DeleteMapping("/reviews/{id}")
    public String deleteReview(@PathVariable Long id) {

        reviewService.deleteReview(id);

        return "Review deleted successfully";
    }

    // Hide review using id
    @PutMapping("/reviews/hide/{id}")
    public String hideReview(@PathVariable Long id) {

        Optional<Review> optionalReview = reviewService.getReviewById(id);

        if (optionalReview.isPresent()) {

            Review review = optionalReview.get();

            review.setHidden(true);

            reviewService.saveReview(review);

            return "Review hidden successfully";
        }

        return "Review not found";
    }
}

