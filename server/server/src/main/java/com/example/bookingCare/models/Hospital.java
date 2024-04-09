package com.example.bookingCare.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String location;

    @OneToMany
    @JoinColumn(name="hospital_id")
    public List<Department> departments;
}
