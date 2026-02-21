package com.smartcity.controller;
// Controller handles HTTP requests like register & login.

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// This is used to hash and verify passwords.

import java.util.List;

import com.smartcity.entity.User;
import com.smartcity.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;
    // Used to communicate with database

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    // Injecting password encoder bean from SecurityConfig


    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        user.setRole("USER");
        // Assign default role

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
        // Save encrypted password to database
    }


    @PostMapping("/login")
    public String loginUser(@RequestBody User loginUser) {

        User user = userRepository.findByEmail(loginUser.getEmail());
        // Find user by email

        if (user == null) {
            return "User not found";
        }

        // Compare entered password with encrypted password
        if (!passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            return "Invalid password";
        }

        return "Login successful. Role: " + user.getRole();
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}