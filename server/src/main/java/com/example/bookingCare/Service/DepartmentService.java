package com.example.bookingCare.Service;

import com.example.bookingCare.models.Department;
import com.example.bookingCare.models.Hospital;
import com.example.bookingCare.models.Symptom;
import com.example.bookingCare.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private SymptomService symptomService;
    public List<Department> findAllDepartment() {
        return this.departmentRepository.findAll();
    }
    public Department findDepartmentById(Long id) {
        Optional<Department> optionalDepartment = this.departmentRepository.findById(id);
        return optionalDepartment.orElse(null);
    }
    public List<Department> findDepartmentsByHospitalId(Long hospitalId) {
        return this.departmentRepository.findAll()
                .stream()
                .filter(department -> department.getHospital().getId().equals(hospitalId))
                .collect(Collectors.toList());
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
    public Department updateDepartment(Department editDepartment,Long id) {
        System.out.println("sjafgjks");
        return this.departmentRepository.findById(id)
                .map(department -> {
                    department.setId(editDepartment.getId());
                    department.setLocation(editDepartment.getLocation());
                    department.setName(editDepartment.getName());
                    return this.departmentRepository.save(department);
                })
                .orElse(null);
    }
    public boolean deleteHospitalById(Long id) {
        Optional<Department> optionalDepartment = this.departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            this.departmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public Department findDepartmentBySymptom(String symtom) {
        Symptom symptom = this.symptomService.findAllSymptomByName(symtom);
        return symptom.getDepartment();
    }
}