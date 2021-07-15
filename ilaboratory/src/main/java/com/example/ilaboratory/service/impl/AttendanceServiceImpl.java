package com.example.ilaboratory.service.impl;

import com.example.ilaboratory.domain.*;
import com.example.ilaboratory.repository.AttendanceRepository;
import com.example.ilaboratory.service.AttendanceService;
import com.example.ilaboratory.service.LaboratoryService;
import com.example.ilaboratory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    UserService userService;
    @Autowired
    LaboratoryService laboratoryService;

    public List<Attendance> listAllByLabId(Long id) {
        return attendanceRepository.findAllByLaboratory_Lid(id);
    }

    public void save(Attendance attendance, Long id) {
        Laboratory laboratory = laboratoryService.findById(id);
        User user = userService.getCurrentUser();
        Student student = user.getStudent();
        attendance.setStudent2(student);
        attendance.setLaboratory(laboratory);
        attendanceRepository.save(attendance);
    }
}
