package com.example.bookingCare.controllers;

import com.example.bookingCare.Service.HospitalService;
import com.example.bookingCare.Service.UserService;
import com.example.bookingCare.models.Hospital;
import com.example.bookingCare.models.User;
import com.example.bookingCare.models.UserNoPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/Hospital")
@CrossOrigin
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;
    @GetMapping("/GetAllHospital")
    public ResponseEntity<List<Hospital>> getAllHospital() {
        try {
            List<Hospital> hospitals = this.hospitalService.findAllHospital();
            return new ResponseEntity<>(hospitals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/GetHospital/{id}")
    public ResponseEntity<Object> getHospitalById(@PathVariable("id") Long id) {
        boolean checkValidId = this.hospitalService.checkValidID(id);
        if (!checkValidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing user ID");
        } else {
            try {
                Hospital hospital = this.hospitalService.findHospitalById(id);
                if (hospital != null) return new ResponseEntity<>(hospital, HttpStatus.OK);
                else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PostMapping(path = "/CreateNewHospital", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> newUser(@RequestBody Hospital newHospital) {
        try {

            this.hospitalService.createHospital(newHospital);
            return ResponseEntity.status(HttpStatus.OK).body("create hospital success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save hospital: " + e.getMessage());
        }
    }

    @PutMapping(path = "/UpdateHospitalById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateUser(@RequestBody Hospital editHospital, @PathVariable("id") Long id) {
        boolean checkValidId = this.hospitalService.checkValidID(id);
        if (!checkValidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing Hospital ID");
        } else {
            Hospital updatedHospital = this.hospitalService.updateHospital(editHospital, id);
            if (updatedHospital != null) {
                return ResponseEntity.status(HttpStatus.OK).body("Hospital updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hospital not found with id: " + id);
            }
        }
    }

    @DeleteMapping("/DeleteHospitalById/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        boolean checkValidId = this.hospitalService.checkValidID(id);
        if (!checkValidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing user ID");
        } else {
            boolean deleted = this.hospitalService.deleteHospitalById(id);
            if (deleted) {
                return ResponseEntity.status(HttpStatus.OK).body("User with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
            }
        }
    }

}
