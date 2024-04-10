package com.example.bookingCare.Service;

import com.example.bookingCare.models.Symptom;
import com.example.bookingCare.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SymptomService {
    @Autowired
    private SymptomRepository symptomRepository;
    public List<Symptom> findAllSymptom() {
        List<Symptom> symptoms = this.symptomRepository.findAll();
        Set<String> uniqueNames = new HashSet<>();
        List<Symptom> uniqueSymptoms = new ArrayList<>();

        for (Symptom symptom : symptoms) {
            if (uniqueNames.add(symptom.getName())) {
                uniqueSymptoms.add(symptom);
            }
        }

        return uniqueSymptoms;
    }
    public Symptom findAllSymptomByName(String symptom) {
        return this.symptomRepository.findByName(symptom).get(0);
    }
}
