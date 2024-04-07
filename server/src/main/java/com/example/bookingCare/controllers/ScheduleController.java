package com.example.bookingCare.controllers;

import com.example.bookingCare.Service.ScheduleService;
import com.example.bookingCare.Service.UserService;
import com.example.bookingCare.models.Schedule;
import com.example.bookingCare.models.SchedulewithDoctor;
import com.example.bookingCare.models.User;
import com.example.bookingCare.models.UserNoPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/Schedule")
@CrossOrigin
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

//    @GetMapping("/getAllSchedule/{departmentid}")
//    public ResponseEntity<List<Schedule>> getAllSchedule(@PathVariable("departmentid") Long id) {
//        try {
//            List<Schedule> schedules = this.scheduleService.findAllSchedule(id);
//            return new ResponseEntity<>(schedules, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
//        }
//    }
    @GetMapping("/getAllSchedule/{doctor_id}")
    public ResponseEntity<List<Schedule>> getAllScheduleByDoctorId(@PathVariable("doctor_id") Long doctor_id) {
        try {
            List<Schedule> schedules = this.scheduleService.findAllScheduleByDoctorId(doctor_id);
            return new ResponseEntity<>(schedules, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/CreateNewSchedule")
    public ResponseEntity<Object> newUser(@RequestBody Schedule newschedule) {
        try {
            this.scheduleService.createNewSchedule(newschedule);
            return ResponseEntity.status(HttpStatus.OK).body("create schedule success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save schedule: " + e.getMessage());
        }
    }
    @DeleteMapping("/DeleteScheduleById/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        boolean checkvalidId = this.scheduleService.checkValidID(id);
        if (!checkvalidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing schedule ID");
        } else {
            boolean deleted = this.scheduleService.deleteScheduleById(id);
            if (deleted) {
                return ResponseEntity.status(HttpStatus.OK).body("Schedule with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Schedule not found with ID: " + id);
            }
        }
    }
    @PutMapping(path = "/UpdateScheduleById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateSchedule(@RequestBody Schedule editSchedule, @PathVariable("id") Long id) {
        boolean checkvalidId = this.scheduleService.checkValidID(id);
        if (!checkvalidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing schedule ID");
        } else {
            Schedule updatedSchedule = this.scheduleService.updateSchedule(editSchedule, id);
            if (updatedSchedule != null) {
                return ResponseEntity.status(HttpStatus.OK).body("Schedule updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Schedule not found with id: " + id);
            }
        }
    }
}
