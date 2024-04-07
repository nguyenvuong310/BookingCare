package com.example.bookingCare.controllers;

import com.example.bookingCare.Service.DoctorService;
import com.example.bookingCare.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin
public class DoctorController {
    @Autowired
    private DoctorService DoctorService;
    @GetMapping("/GetAllDoctor")
    public ResponseEntity<List<Doctor>> getAllDoctor() {
        try {
            List<Doctor> Doctors = this.DoctorService.findAllDoctor();
            return new ResponseEntity<>(Doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/GetDoctorByDepartmentId/{id}")
    public ResponseEntity<Object> getDoctorByDepartmentId(@PathVariable("id") Long id) {
        boolean checkvalidId = this.DoctorService.checkValidID(id);
        if (!checkvalidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing Doctor ID");
        } else {
            try {
                List<Doctor> doctors = this.DoctorService.findDoctorByDepartmentId(id);
                if (doctors != null) return new ResponseEntity<>(doctors, HttpStatus.OK);
                else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found with ID: " + id);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
    @PostMapping("/CreateNewDoctor")
    public ResponseEntity<Object> newDoctor(@RequestBody Doctor newDoctor, @RequestParam("department_id") Long id) {
        try {
            this.DoctorService.createNewDoctor(newDoctor, id);
            return ResponseEntity.status(HttpStatus.OK).body("create Doctor success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save Doctor: " + e.getMessage());
        }
    }

    @PutMapping(path = "/UpdateDoctorById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateDoctor(@RequestBody Doctor editDoctor, @PathVariable("id") Long id) {
        boolean checkvalidId = this.DoctorService.checkValidID(id);
        if (!checkvalidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing Doctor ID");
        } else {
            Doctor updatedDoctor = this.DoctorService.updateDoctor(editDoctor, id);
            if (updatedDoctor != null) {
                return ResponseEntity.status(HttpStatus.OK).body("Doctor updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found with id: " + id);
            }
        }
    }

    @DeleteMapping("/DeleteDoctorById/{id}")
    public ResponseEntity<Object> deleteDoctor(@PathVariable Long id) {
        boolean checkvalidId = this.DoctorService.checkValidID(id);
        if (!checkvalidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing Doctor ID");
        } else {
            boolean deleted = this.DoctorService.deleteDoctorById(id);
            if (deleted) {
                return ResponseEntity.status(HttpStatus.OK).body("Doctor with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found with ID: " + id);
            }
        }
    }
}
