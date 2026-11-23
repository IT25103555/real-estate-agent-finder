package com.example.project.repository;

import com.example.project.entity.Appointment;
import com.example.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// This repository handles database operations for appointments
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Find appointments using agent
    List<Appointment> findByAgent(User agent);

    // Find appointments using buyer
    List<Appointment> findByBuyer(User buyer);
}