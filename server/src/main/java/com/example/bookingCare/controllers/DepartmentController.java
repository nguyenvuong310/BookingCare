package com.example.bookingCare.controllers;

import com.example.bookingCare.Service.DepartmentService;
import com.example.bookingCare.models.Department;
import com.example.bookingCare.models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/Department")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/GetAllDepartment")
    public ResponseEntity<List<Department>> getAllDepartment() {
        try {
            List<Department> departments = this.departmentService.findAllDepartment();
            return new ResponseEntity<>(departments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/GetDepartment/{id}")
    public ResponseEntity<Object> getDepartmentById(@PathVariable("id") Long id) {
        boolean checkValidId = this.departmentService.checkValidID(id);
        if (!checkValidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing schedule ID");
        } else {
            try {
                Department department = this.departmentService.findDepartmentById(id);
                if (department != null) return new ResponseEntity<>(department, HttpStatus.OK);
                else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Schedule not found with ID: " + id);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
    @PostMapping(path = "/CreateNewDepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> newDepartment(@RequestBody Department newDepartment, @RequestParam("hospital_id") Long id) {
        try {
            this.departmentService.createDepartment(newDepartment, id);
            return ResponseEntity.status(HttpStatus.OK).body("create department success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save department: " + e.getMessage());
        }
    }
}
