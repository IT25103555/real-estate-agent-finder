package com.example.project.controller;

import com.example.project.entity.Notification;
import com.example.project.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// This controller handles notification APIs
@RestController

// Base URL for notification APIs
@RequestMapping("/notifications")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	// Get all notifications (Admin only)
	@GetMapping
	public List<Notification> getAllNotifications() {
		return notificationService.getAllNotifications();
	}

	// Get notification by id
	@GetMapping("/{id}")
	public Optional<Notification> getNotificationById(@PathVariable Long id) {
		return notificationService.getNotificationById(id);
	}

	// Get all notifications for a seller
	@GetMapping("/seller/{sellerId}")
	public List<Notification> getNotificationsBySeller(@PathVariable Long sellerId) {
		return notificationService.getNotificationsBySeller(sellerId);
	}

	// Get unread notifications for a seller
	@GetMapping("/seller/{sellerId}/unread")
	public List<Notification> getUnreadNotificationsBySeller(@PathVariable Long sellerId) {
		return notificationService.getUnreadNotificationsBySeller(sellerId);
	}

	// Delete notification (Seller can delete their own)
	@DeleteMapping("/{id}")
	public String deleteNotification(@PathVariable Long id) {
		notificationService.deleteNotification(id);
		return "Notification deleted successfully";
	}

	// Mark notification as read
	@PutMapping("/{id}/read")
	public Notification markAsRead(@PathVariable Long id) {
		return notificationService.markAsRead(id);
	}
}

