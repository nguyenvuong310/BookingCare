package com.example.bookingCare.controllers;

import com.example.bookingCare.Service.AppointmentService;
import com.example.bookingCare.Service.DepartmentService;
import com.example.bookingCare.models.Appointment;
import com.example.bookingCare.models.Department;
import com.example.bookingCare.models.Hospital;
import com.example.bookingCare.models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/Appointment")
@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @GetMapping("/GetAllDepartmentByDoctor/{doctor_id}")
    public ResponseEntity<List<Appointment>> getAllDepartmentByDoctorId(@PathVariable("doctor_id") Long id) {
        try {
            List<Appointment> appointment = this.appointmentService.findAllAppointmentByDoctorId(id);
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="/CreateNewAppointment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> newUser(@RequestBody Appointment newAppointment, @RequestParam("department_id") Long Did, @RequestParam("user_id") Long Uid) {
        try {
            this.appointmentService.createAppointment(newAppointment, Did, Uid);
            return ResponseEntity.status(HttpStatus.OK).body("create appointment success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save appointment: " + e.getMessage());
        }
    }

    @PutMapping(path = "/UpdateAppointmentById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateUser(@RequestBody Appointment editAppointment, @PathVariable("id") Long id) {
        boolean checkValidId = this.appointmentService.checkValidID(id);
        if (!checkValidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing Hospital ID");
        } else {
            Appointment updateAppointment = this.appointmentService.updateAppointment(editAppointment, id);
            if (updateAppointment != null) {
                return ResponseEntity.status(HttpStatus.OK).body("Appointment updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found with id: " + id);
            }
        }
    }

    @DeleteMapping("/DeleteAppointment/{id}")
    public ResponseEntity<Object> deleteAppointment(@PathVariable Long id) {
        boolean checkValidId = this.appointmentService.checkValidID(id);
        if (!checkValidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing appointment ID");
        } else {
            boolean deleted = this.appointmentService.deleteAppointment(id);
            if (deleted) {
                return ResponseEntity.status(HttpStatus.OK).body("Appointment with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found with ID: " + id);
            }
        }
    }
}
