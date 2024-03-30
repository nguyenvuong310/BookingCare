package com.example.bookingCare.controllers;


import com.example.bookingCare.models.User;
import com.example.bookingCare.repository.UserRepository;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController

public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/get-all-user")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<List<User>>(this.userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/add-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> newUser(@RequestBody User newUser) {
        try {
            this.userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.OK).body("create user success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save user: " + e.getMessage());
        }
    }
    @PutMapping(path = "/update-user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateUser(@RequestBody User editUser, @PathVariable("id") Long id) {
        if (id <= 0 ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing user ID");
        }
        User updatedUser = this.userRepository.findById(id)
                .map(user -> {
                    user.setEmail(editUser.getEmail());
                    user.setFirstname(editUser.getFirstname());
                    user.setLastname(editUser.getLastname());
                    user.setPassword(editUser.getPassword());
                    return this.userRepository.save(user);
                })
                .orElse(null);

        if (updatedUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
    }
    @DeleteMapping("/del-user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        if (id <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing user ID");
        }
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isPresent()) {
            this.userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("User with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }
    }



}
