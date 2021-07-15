package com.example.ilaboratory.controller;


import com.example.ilaboratory.domain.User;
import com.example.ilaboratory.service.LaboratoryService;
import com.example.ilaboratory.service.StudentService;
import com.example.ilaboratory.service.UserService;
import com.example.ilaboratory.viewmodel.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    private LaboratoryService laboratoryService;
    @Autowired
    private RegistrationModel registrationModel;

    @GetMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("labs", laboratoryService.listAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @GetMapping(value = {"/", "/login"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value = "/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("registration", registrationModel.create(user, bindingResult) );
        return modelAndView;
    }






}
