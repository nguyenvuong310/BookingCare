package com.example.bookingCare.Service;

import com.example.bookingCare.models.Department;
import com.example.bookingCare.models.Hospital;
import com.example.bookingCare.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private HospitalService hospitalService;

    public List<Department> findAllDepartment() {
        return this.departmentRepository.findAll();
    }
    public Department findDepartmentById(Long id) {
        Optional<Department> optionalDepartment = this.departmentRepository.findById(id);
        return optionalDepartment.orElse(null);
    }
    public boolean checkValidID(Long id) {
        if (id <= 0) return false;
        return true;
    }

    public void createDepartment(Department department, Long id) {
        Hospital hospital = this.hospitalService.findHospitalById(id);
        department.setHospital(hospital);
        this.departmentRepository.save(department);
    }
//    public Hospital updateHospital(Hospital editHospital,Long id) {
//        return this.departmentRepository.findById(id)
//                .map(hospital -> {
//                    hospital.setLocation(editHospital.getLocation());
//                    hospital.setName(editHospital.getName());
//                    return this.hospitalRepository.save(hospital);
//                })
//                .orElse(null);
//    }
//    public boolean deleteHospitalById(Long id) {
//        Optional<Hospital> optionalUser = this.hospitalRepository.findById(id);
//        if (optionalUser.isPresent()) {
//            this.hospitalRepository.deleteById(id);
//            return true;
//        } else {
//            return false;
//        }
//    }
}
