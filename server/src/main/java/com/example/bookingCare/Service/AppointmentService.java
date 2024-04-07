package com.example.bookingCare.Service;

import com.example.bookingCare.models.Appointment;
import com.example.bookingCare.models.Department;
import com.example.bookingCare.models.User;
import com.example.bookingCare.models.UserNoPassword;
import com.example.bookingCare.repository.AppointmentRepository;
import com.example.bookingCare.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private UserService userService;

    public List<Appointment> findAllAppointmentByDoctorId(Long id) {
        return this.appointmentRepository.findByDoctorId(id);
    }
    public Appointment findAppointmentById(Long id) {
        Optional<Appointment> optionalAppointment = this.appointmentRepository.findById(id);
        return optionalAppointment.orElse(null);
    }
    public boolean checkValidID(Long id) {
        if (id <= 0) return false;
        return true;
    }

    public void createAppointment(Appointment appointment, Long Did, Long Uid) {
        Department department = this.departmentService.findDepartmentById(Did);
        appointment.setDepartment(department);
        User user = this.userService.findUserHavePasswordById(Uid);
        appointment.setUser(user);
        this.appointmentRepository.save(appointment);
    }
    public Appointment updateAppointment(Appointment editAppointment,Long id) {
    return this.appointmentRepository.findById(id)
            .map(appointment -> {
                appointment.setDate(editAppointment.getDate());
                appointment.setTime(editAppointment.getTime());
                appointment.setStatus(editAppointment.getStatus());
                return this.appointmentRepository.save(appointment);
            })
            .orElse(null);
    }
        public boolean deleteAppointment(Long id) {
        Optional<Appointment> optionalAppointment = this.appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            this.appointmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
