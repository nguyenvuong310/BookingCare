package com.example.bookingCare.controllers;


import com.example.bookingCare.Service.UserService;
import com.example.bookingCare.models.User;
import com.example.bookingCare.models.UserNoPassword;
import com.example.bookingCare.repository.UserRepository;
import org.springframework.core.SpringVersion;
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
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/GetAllUser")
    public ResponseEntity<List<UserNoPassword>> getAllUser() {
        try {
            List<UserNoPassword> users = this.userService.findAllUser();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/GetUser/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
        boolean checkvalidId = this.userService.checkValidID(id);
        if (!checkvalidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing user ID");
        } else {
            try {
                UserNoPassword user = this.userService.findUserById(id);
                if (user != null) return new ResponseEntity<>(user, HttpStatus.OK);
                else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
    @PostMapping("/CreateNewUser")
    public ResponseEntity<Object> newUser(@RequestBody User newUser) {
        try {
            this.userService.createNewUser(newUser);
            return ResponseEntity.status(HttpStatus.OK).body("create user success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save user: " + e.getMessage());
        }
    }

    @PutMapping(path = "/UpdateUserById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateUser(@RequestBody User editUser, @PathVariable("id") Long id) {
        boolean checkvalidId = this.userService.checkValidID(id);
        if (!checkvalidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing user ID");
        } else {
            User updatedUser = this.userService.updateUser(editUser, id);
            if (updatedUser != null) {
                return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
            }
        }
    }

    @DeleteMapping("/DeleteUserById/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        boolean checkvalidId = this.userService.checkValidID(id);
        if (!checkvalidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing user ID");
        } else {
            boolean deleted = this.userService.deleteUserById(id);
            if (deleted) {
                return ResponseEntity.status(HttpStatus.OK).body("User with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
            }
        }
    }
    @GetMapping("/handleLogin")
    public ResponseEntity<UserNoPassword> handleLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            UserNoPassword user = this.userService.handleLogin(username, password);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
