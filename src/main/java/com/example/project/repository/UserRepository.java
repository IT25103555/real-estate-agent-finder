package com.example.project.repository;

import com.example.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// This repository handles database operations for users
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user using email
    Optional<User> findByEmail(String email);
}
