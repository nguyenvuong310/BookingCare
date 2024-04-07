package com.example.bookingCare.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String symptom;

    @Column(nullable = false)
    public String location;

    @ManyToOne
    @JoinColumn(name="hospital_id")
    public Hospital hospital;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
