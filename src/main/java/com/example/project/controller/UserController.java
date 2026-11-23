package com.example.project.controller;

import com.example.project.dto.LoginDTO;
import com.example.project.dto.UserRegistrationDTO;
import com.example.project.entity.User;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// This controller handles user APIs
@RestController

// Base URL for user APIs
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user using id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Delete user using id
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully";
    }

    // Register new buyer
    @PostMapping("/register/buyer")
    public User registerBuyer(@RequestBody UserRegistrationDTO registrationDTO) {
        return userService.registerBuyer(registrationDTO);
    }

    // Register new seller
    @PostMapping("/register/seller")
    public User registerSeller(@RequestBody UserRegistrationDTO registrationDTO) {
        return userService.registerSeller(registrationDTO);
    }

    // Register new agent
    @PostMapping("/register/agent")
    public User registerAgent(@RequestBody UserRegistrationDTO registrationDTO) {
        return userService.registerAgent(registrationDTO);
    }

	// User login API
	@PostMapping("/login")
	public String loginUser(@RequestBody LoginDTO loginDTO) {

		// Find user using email
		Optional<User> optionalUser = userService.getUserByEmail(loginDTO.getEmail());

		// Check user exists
		if (optionalUser.isPresent()) {

			User dbUser = optionalUser.get();

			// Check password
			if (dbUser.getPassword().equals(loginDTO.getPassword())) {

				return "Login successful";
			}
		}

		// Invalid email or password
		return "Invalid email or password";
	}
}