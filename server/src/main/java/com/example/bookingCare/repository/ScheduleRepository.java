package com.example.bookingCare.repository;

import com.example.bookingCare.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByDepartmentId(Long departmentId);
    List<Schedule> findByDoctorListId(Long departmentId);
}
