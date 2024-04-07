package com.example.bookingCare.Service;

import com.example.bookingCare.models.Department;
import com.example.bookingCare.models.Doctor;
import com.example.bookingCare.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository DoctorRepository;
    @Autowired
    private DepartmentService departmentService;
    public List<Doctor> findAllDoctor() {
        List<Doctor> doctors = this.DoctorRepository.findAll();
        return doctors;
    }
    public List<Doctor> findDoctorByDepartmentId(Long id) {
        return this.DoctorRepository.findAll()
                .stream()
                .filter(doctor -> doctor.getDepartment().getId().equals(id))
                .collect(Collectors.toList());
    }

    public void createNewDoctor(Doctor doctor, Long id) {
        Department department = this.departmentService.findDepartmentById(id);
        doctor.setDepartment(department);
        this.DoctorRepository.save(doctor);
    }
    public boolean checkValidID(Long id) {
        if (id <= 0) return false;
        return true;
    }
    public Doctor updateDoctor(Doctor editDoctor,Long id) {
        return this.DoctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setName(editDoctor.getName());
                    doctor.setUserName(editDoctor.getUserName());
                    doctor.setAddress(editDoctor.getAddress());
                    doctor.setBirthday(editDoctor.getBirthday());
                    doctor.setPhoneNumber(editDoctor.getPhoneNumber());
                    doctor.setPassword(editDoctor.getPassword());
                    doctor.setGender(editDoctor.getGender());
                    doctor.setQualifications(editDoctor.getQualifications());
                    return this.DoctorRepository.save(doctor);
                })
                .orElse(null);
    }
    public boolean deleteDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = this.DoctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            this.DoctorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
