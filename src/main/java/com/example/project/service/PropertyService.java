package com.example.project.service;

import com.example.project.entity.Notification;
import com.example.project.entity.Property;
import com.example.project.enums.PropertyStatus;
import com.example.project.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// This service handles property business logic
@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private NotificationService notificationService;

    // Save new property
    public Property saveProperty(Property property) {

        // Set created date
        property.setCreatedDate(LocalDate.now());

        // Default property status
        property.setStatus(PropertyStatus.PENDING);

        return propertyRepository.save(property);
    }

    // Get all properties
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    // Get property using id
    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    // Delete property using id
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    // Find properties using location
    public List<Property> getPropertiesByLocation(String location) {
        return propertyRepository.findByLocation(location);
    }

	// Accept property
	public Property acceptProperty(Long id) {

		Property property = propertyRepository.findById(id).orElseThrow();

		property.setStatus(PropertyStatus.ACCEPTED);

		Property savedProperty = propertyRepository.save(property);

		// Send notification to seller
		Notification notification = new Notification();
		notification.setMessage("Your property '" + property.getTitle() + "' has been accepted!");
		notification.setProperty(property);
		notification.setSeller(property.getSeller());
		notificationService.createNotification(notification);

		return savedProperty;
	}

	// Reject property
	public Property rejectProperty(Long id) {

		Property property = propertyRepository.findById(id).orElseThrow();

		property.setStatus(PropertyStatus.REJECTED);

		Property savedProperty = propertyRepository.save(property);

		// Send notification to seller
		Notification notification = new Notification();
		notification.setMessage("Your property '" + property.getTitle() + "' has been rejected.");
		notification.setProperty(property);
		notification.setSeller(property.getSeller());
		notificationService.createNotification(notification);

		return savedProperty;
	}
}