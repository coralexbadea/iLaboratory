package com.example.ilaboratory.controller;

import com.example.ilaboratory.domain.Attendance;
import com.example.ilaboratory.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @GetMapping(value = "/index/{id}")
    public ModelAndView getattendances(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Attendance> attendances = attendanceService.listAllByLabId(id);
        modelAndView.addObject("attendances", attendances);
        modelAndView.setViewName("attendance/index");
        return modelAndView;
    }


    @RequestMapping(value = "/attend/{id}")
    public String create(@PathVariable(name = "id") Long id, @Valid Attendance attendance) {
        attendanceService.save(attendance, id);
        return "redirect:/viewLaboratory/"+ id;
    }


}
