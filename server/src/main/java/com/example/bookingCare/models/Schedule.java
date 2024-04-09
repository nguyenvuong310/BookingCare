package com.example.bookingCare.models;

import jakarta.persistence.*;

import javax.print.Doc;
import java.time.LocalDate;
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
    public LocalDate date;
    @Column(nullable = true)
    public Long slot;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    public Doctor doctor;

    public Schedule() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getSlot() {
        return slot;
    }

    public void setSlot(Long slot) {
        this.slot = slot;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
