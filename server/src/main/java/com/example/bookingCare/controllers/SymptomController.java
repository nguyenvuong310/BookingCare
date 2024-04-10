package com.example.bookingCare.controllers;

import com.example.bookingCare.Service.SymptomService;
import com.example.bookingCare.models.Department;
import com.example.bookingCare.models.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/Symptom")
@CrossOrigin
public class SymptomController {
    @Autowired
    private SymptomService symptomService;
    @GetMapping("/GetAllSymptom")
    public ResponseEntity<List<Symptom>> getAllSymptom() {
        try {
            List<Symptom> symptoms = this.symptomService.findAllSymptom();
            return new ResponseEntity<>(symptoms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/GetAllSymptomByName")
    public ResponseEntity<Symptom> getAllSymptomByName(String symptom) {
        try {
            Symptom symptoms = this.symptomService.findAllSymptomByName(symptom);
            return new ResponseEntity<>(symptoms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
