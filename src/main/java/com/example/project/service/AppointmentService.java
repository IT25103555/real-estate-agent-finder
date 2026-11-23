package com.example.project.service;

import com.example.project.entity.Appointment;
import com.example.project.enums.AppointmentStatus;
import com.example.project.repository.AppointmentRepository;
import com.example.project.repository.UserRepository;
import com.example.project.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This service handles appointment business logic
@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PropertyRepository propertyRepository;

	// Save new appointment with validation
	public Appointment saveAppointment(Appointment appointment) {

		// Validate agent exists if agent_id is provided
		if (appointment.getAgent() != null && appointment.getAgent().getId() != null) {
			if (!userRepository.existsById(appointment.getAgent().getId())) {
				throw new IllegalArgumentException("Agent with ID " + appointment.getAgent().getId() + " does not exist");
			}
		}

		// Validate buyer exists if buyer_id is provided
		if (appointment.getBuyer() != null && appointment.getBuyer().getId() != null) {
			if (!userRepository.existsById(appointment.getBuyer().getId())) {
				throw new IllegalArgumentException("Buyer with ID " + appointment.getBuyer().getId() + " does not exist");
			}
		}

		// Validate property exists if property_id is provided
		if (appointment.getProperty() != null && appointment.getProperty().getId() != null) {
			if (!propertyRepository.existsById(appointment.getProperty().getId())) {
				throw new IllegalArgumentException("Property with ID " + appointment.getProperty().getId() + " does not exist");
			}
		}

		// Default appointment status
		appointment.setStatus(AppointmentStatus.PENDING);

		return appointmentRepository.save(appointment);
	}

	// Get all appointments
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	// Get appointment using id
	public Optional<Appointment> getAppointmentById(Long id) {
		return appointmentRepository.findById(id);
	}

	// Delete appointment using id
	public void deleteAppointment(Long id) {
		appointmentRepository.deleteById(id);
	}

	// Accept appointment
	public Appointment acceptAppointment(Long id) {

		Appointment appointment = appointmentRepository.findById(id).orElseThrow();

		appointment.setStatus(AppointmentStatus.ACCEPTED);

		return appointmentRepository.save(appointment);
	}

	// Reject appointment
	public Appointment rejectAppointment(Long id) {

		Appointment appointment = appointmentRepository.findById(id).orElseThrow();

		appointment.setStatus(AppointmentStatus.REJECTED);

		return appointmentRepository.save(appointment);
	}
}