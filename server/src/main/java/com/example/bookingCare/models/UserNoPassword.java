package com.example.bookingCare.models;

import jakarta.persistence.*;

<<<<<<< HEAD
import java.time.LocalDate;
=======
>>>>>>> 531cc546870721d1f3e0f000e0f289f3484a8436
import java.util.Date;
import java.util.List;

public class UserNoPassword {
    private Long id;

    public String userName;

    public String name;

    public String gender;

<<<<<<< HEAD
    public LocalDate birthday;
=======
    public Date birthday;
>>>>>>> 531cc546870721d1f3e0f000e0f289f3484a8436

    public String address;

    public String phoneNumber;

    public UserRole role;


    public UserNoPassword(){

    }

<<<<<<< HEAD
    public UserNoPassword(Long id, String userName, String name, String gender, LocalDate birthday, String address, String phoneNumber) {
=======
    public UserNoPassword(Long id, String userName, String name, String gender, Date birthday, String address, String phoneNumber) {
>>>>>>> 531cc546870721d1f3e0f000e0f289f3484a8436
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

<<<<<<< HEAD
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
=======
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
>>>>>>> 531cc546870721d1f3e0f000e0f289f3484a8436
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
