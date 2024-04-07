package com.example.bookingCare.Service;

import com.example.bookingCare.models.Doctor;
import com.example.bookingCare.models.Schedule;
import com.example.bookingCare.models.SchedulewithDoctor;
import com.example.bookingCare.models.User;
import com.example.bookingCare.repository.ScheduleRepository;
import com.example.bookingCare.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private  DoctorRepository doctorRepository;
    public List<Schedule> findAllScheduleByDoctorId(Long doctor_id) {
        List<Schedule> schedules = this.scheduleRepository.findByDoctorListId(doctor_id);
        return schedules;
    }

    public void createNewSchedule(Schedule schedule) {
        this.scheduleRepository.save(schedule);
    }
    public boolean checkValidID(Long id) {
        if (id <= 0) return false;
        return true;
    }
    public boolean deleteScheduleById(Long id) {
        Optional<Schedule> optionalSchedule = this.scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            this.scheduleRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public Schedule updateSchedule(Schedule editSchedule,Long id) {
        return this.scheduleRepository.findById(id)
                .map(schedule -> {
                    schedule.setId(editSchedule.getId());
                    schedule.setSlot(editSchedule.getSlot());
                    schedule.setTime(editSchedule.getTime());
                    schedule.setDepartment(editSchedule.getDepartment());
                    schedule.setDoctorList(editSchedule.getDoctorList());
                    return this.scheduleRepository.save(schedule);
                })
                .orElse(null);
    }
}
