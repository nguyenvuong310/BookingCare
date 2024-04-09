package com.example.bookingCare.models;

import jakarta.persistence.*;

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

}
