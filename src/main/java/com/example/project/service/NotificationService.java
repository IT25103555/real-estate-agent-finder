package com.example.project.service;

import com.example.project.entity.Notification;
import com.example.project.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// This service handles notification business logic
@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	// Create new notification
	public Notification createNotification(Notification notification) {
		notification.setCreatedDate(LocalDate.now());
		notification.setRead(false);
		return notificationRepository.save(notification);
	}

	// Get all notifications (admin)
	public List<Notification> getAllNotifications() {
		return notificationRepository.findAll();
	}

	// Get notification by id
	public Optional<Notification> getNotificationById(Long id) {
		return notificationRepository.findById(id);
	}

	// Get all notifications for a specific seller
	public List<Notification> getNotificationsBySeller(Long sellerId) {
		return notificationRepository.findBySellerId(sellerId);
	}

	// Get unread notifications for a specific seller
	public List<Notification> getUnreadNotificationsBySeller(Long sellerId) {
		return notificationRepository.findBySellerIdAndIsReadFalse(sellerId);
	}

	// Delete notification
	public void deleteNotification(Long id) {
		notificationRepository.deleteById(id);
	}

	// Mark notification as read
	public Notification markAsRead(Long id) {
		Notification notification = notificationRepository.findById(id).orElseThrow();
		notification.setRead(true);
		return notificationRepository.save(notification);
	}
}

