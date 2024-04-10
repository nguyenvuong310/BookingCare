package com.example.bookingCare.repository;

import com.example.bookingCare.models.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {
    List<Symptom> findByName(String name);
}
