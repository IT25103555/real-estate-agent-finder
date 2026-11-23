package com.example.project.controller;

import com.example.project.entity.Appointment;
import com.example.project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// This controller handles appointment APIs
@RestController

// Base URL for appointment APIs
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Create new appointment
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {

        return appointmentService.saveAppointment(appointment);
    }

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {

        return appointmentService.getAllAppointments();
    }

    // Get appointment using id
    @GetMapping("/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id) {

        return appointmentService.getAppointmentById(id);
    }

    // Accept appointment request
    @PutMapping("/accept/{id}")
    public Appointment acceptAppointment(@PathVariable Long id) {

        return appointmentService.acceptAppointment(id);
    }

    // Reject appointment request
    @PutMapping("/reject/{id}")
    public Appointment rejectAppointment(@PathVariable Long id) {

        return appointmentService.rejectAppointment(id);
    }

    // Delete appointment using id
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {

        appointmentService.deleteAppointment(id);

        return "Appointment deleted successfully";
    }
}