package com.example.bookingCare.Service;

import com.example.bookingCare.models.Hospital;
import com.example.bookingCare.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    public List<Hospital> findAllHospital() {
        return this.hospitalRepository.findAll();
    }
    public Hospital findHospitalById(Long id) {
        Optional<Hospital> optionalHospital = this.hospitalRepository.findById(id);
        return optionalHospital.orElse(null);
    }
    public boolean checkValidID(Long id) {
        if (id <= 0) return false;
        return true;
    }
    public void createHospital(Hospital hospital) {
        this.hospitalRepository.save(hospital);

    }
    public Hospital updateHospital(Hospital editHospital,Long id) {
        return this.hospitalRepository.findById(id)
                .map(hospital -> {
                    hospital.setLocation(editHospital.getLocation());
                    hospital.setName(editHospital.getName());
                    return this.hospitalRepository.save(hospital);
                })
                .orElse(null);
    }
    public boolean deleteHospitalById(Long id) {
        Optional<Hospital> optionalUser = this.hospitalRepository.findById(id);
        if (optionalUser.isPresent()) {
            this.hospitalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
