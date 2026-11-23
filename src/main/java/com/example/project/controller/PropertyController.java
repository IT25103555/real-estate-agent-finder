package com.example.project.controller;

import com.example.project.entity.Property;
import com.example.project.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// This controller handles property APIs
@RestController

// Base URL for property APIs
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // Create new property
    @PostMapping
    public Property createProperty(@RequestBody Property property) {

        return propertyService.saveProperty(property);
    }

    // Get all properties
    @GetMapping
    public List<Property> getAllProperties() {

        return propertyService.getAllProperties();
    }

    // Get property using id
    @GetMapping("/{id}")
    public Optional<Property> getPropertyById(@PathVariable Long id) {

        return propertyService.getPropertyById(id);
    }

    // Delete property using id
    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable Long id) {

        propertyService.deleteProperty(id);

        return "Property deleted successfully";
    }

    // Accept property request
    @PutMapping("/accept/{id}")
    public Property acceptProperty(@PathVariable Long id) {

        return propertyService.acceptProperty(id);
    }

    // Reject property request
    @PutMapping("/reject/{id}")
    public Property rejectProperty(@PathVariable Long id) {

        return propertyService.rejectProperty(id);
    }
}