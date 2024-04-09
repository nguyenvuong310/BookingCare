package com.example.bookingCare.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = true)
    public String userName;

    @Column(nullable = true)
    public String password;

    @Column(nullable = true, unique = true)
    public String name;
    @Column(nullable = true)
    public String gender;

    @Column(nullable = true)
    public LocalDate birthday;

    @Column(nullable = true)
    public String address;

    @Column(nullable = true)
    public String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    public UserRole role;


    public User(){

    }

    public User(Long id, String userName, String password, String name, String gender, LocalDate birthday, String address, String phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
