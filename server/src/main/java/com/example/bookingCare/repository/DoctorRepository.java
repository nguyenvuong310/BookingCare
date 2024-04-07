package com.example.bookingCare.repository;

import com.example.bookingCare.models.Doctor;
import com.example.bookingCare.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends  JpaRepository<Doctor, Long>{
    Doctor findByDepartmentId(Long departmentId);
}

