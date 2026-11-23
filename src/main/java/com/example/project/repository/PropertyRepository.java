package com.example.project.repository;

import com.example.project.entity.Property;
import com.example.project.enums.PropertyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// This repository handles database operations for properties
public interface PropertyRepository extends JpaRepository<Property, Long> {

    // Find properties using property status
    List<Property> findByStatus(PropertyStatus status);

    // Find properties using location
    List<Property> findByLocation(String location);
}