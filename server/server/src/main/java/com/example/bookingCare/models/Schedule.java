package com.example.bookingCare.models;

import jakarta.persistence.*;

import javax.print.Doc;
import java.util.List;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = true)
    public String time;

    @Column(nullable = true)
    public Long slot;
    @ManyToMany
    @JoinTable(
            name= "work_schedule",
           joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    public List<Doctor> doctorList;

    @ManyToOne
    @JoinColumn(name="department_id")
    public Department department;
}
