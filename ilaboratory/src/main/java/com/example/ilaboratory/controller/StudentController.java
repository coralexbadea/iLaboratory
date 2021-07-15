package com.example.ilaboratory.controller;

import com.example.ilaboratory.domain.Laboratory;
import com.example.ilaboratory.domain.Student;
import com.example.ilaboratory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/index")
    public ModelAndView getStudents() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.listAll());
        modelAndView.setViewName("student/index");
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public String create(@Valid Student student) {
        studentService.createStudent(student);
        return "redirect:/student/index";
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndVie = new ModelAndView("student/edit");
        modelAndVie.addObject("student", studentService.findById(id));
        return modelAndVie;
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute("student") Student student) {
        studentService.saveEdit(student);
        return "redirect:/student/index";
    }


    @RequestMapping("/delete/{sid}")
    public String deletelaboratory(@PathVariable (name="sid") Long sid) {
        studentService.delete(sid);
        return "redirect:/student/index";
    }

}
