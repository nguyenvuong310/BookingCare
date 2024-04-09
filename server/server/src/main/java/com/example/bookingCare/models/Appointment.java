package com.example.bookingCare.models;

import jakarta.persistence.*;

@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    public String time;

    @Column(nullable = false)
    public String date;

    @Column(nullable = false)
    public String status;

    @ManyToOne
    @JoinColumn(name="department_id")
    public Department department;

}
