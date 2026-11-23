package com.example.project.repository;

import com.example.project.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This repository handles notification database operations
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

	// Find all notifications for a specific seller
	List<Notification> findBySellerId(Long sellerId);

	// Find all unread notifications for a specific seller
	List<Notification> findBySellerIdAndIsReadFalse(Long sellerId);
}

