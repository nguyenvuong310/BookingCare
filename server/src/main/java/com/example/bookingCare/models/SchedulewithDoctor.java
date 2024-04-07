package com.example.bookingCare.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class SchedulewithDoctor {
    private Doctor doctor;
    private Schedule schedule;

    public SchedulewithDoctor() {

    }
    public SchedulewithDoctor(Doctor doctor, Schedule schedule) {
        this.doctor = doctor;
        this.schedule = schedule;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}

