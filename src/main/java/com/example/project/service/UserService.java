package com.example.project.service;

import com.example.project.dto.UserRegistrationDTO;
import com.example.project.entity.User;
import com.example.project.enums.Role;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// This service handles user business logic
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register new user
    public User saveUser(User user) {

        // Set current date as join date
        user.setJoinDate(LocalDate.now());

        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user using id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete user using id
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Find user using email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Register new buyer user
    public User registerBuyer(UserRegistrationDTO registrationDTO) {
        User user = new User();
        user.setName(registrationDTO.getName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        user.setContactNumber(registrationDTO.getContactNumber());
        user.setRole(Role.BUYER);

        return saveUser(user);
    }

    // Register new seller user
    public User registerSeller(UserRegistrationDTO registrationDTO) {
        User user = new User();
        user.setName(registrationDTO.getName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        user.setContactNumber(registrationDTO.getContactNumber());
        user.setRole(Role.SELLER);

        return saveUser(user);
    }

    // Register new agent user
    public User registerAgent(UserRegistrationDTO registrationDTO) {
        User user = new User();
        user.setName(registrationDTO.getName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        user.setContactNumber(registrationDTO.getContactNumber());
        user.setRole(Role.AGENT);

        return saveUser(user);
    }
}