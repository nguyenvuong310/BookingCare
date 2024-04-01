package com.example.bookingCare.controllers;


import com.example.bookingCare.models.User;
import com.example.bookingCare.repository.UserRepository;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/GetAllUser")
    public ResponseEntity<List<User>> getAllUser() {
        try {
            List<User> users = this.userRepository.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping(path = "/CreateNewUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @PostMapping("/CreateNewUser")
    public ResponseEntity<Object> newUser(@RequestBody User newUser) {
        try {
            this.userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.OK).body("create user success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save user: " + e.getMessage());
        }
    }
    @PutMapping(path = "/UpdateUserById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateUser(@RequestBody User editUser, @PathVariable("id") Long id) {
        if (id <= 0 ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing user ID");
        }
        User updatedUser = this.userRepository.findById(id)
                .map(user -> {
                    user.setName(editUser.getName());
                    user.setUserName(editUser.getUserName());
                    user.setAddress(editUser.getAddress());
                    user.setBirthday(editUser.getBirthday());
                    user.setPhoneNumber(editUser.getPhoneNumber());
                    user.setPassword(editUser.getPassword());
                    user.setGender(editUser.getGender());
                    return this.userRepository.save(user);
                })
                .orElse(null);

        if (updatedUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
    }
    @DeleteMapping("/DeleteUserById/{id}")
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
