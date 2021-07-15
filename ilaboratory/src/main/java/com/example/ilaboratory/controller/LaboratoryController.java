package com.example.ilaboratory.controller;

import com.example.ilaboratory.domain.Laboratory;
import com.example.ilaboratory.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LaboratoryController {
    @Autowired
    LaboratoryService laboratoryService;

    @GetMapping(value = "/newLaboratory")
    public ModelAndView newlaboratory() {
        ModelAndView modelAndView = new ModelAndView();
        Laboratory laboratory = new Laboratory();
        modelAndView.addObject("laboratory", laboratory);
        modelAndView.setViewName("newLaboratory");
        return modelAndView;
    }

    @PostMapping(value = "/newLaboratory")
    public String createNewlaboratory(@Valid Laboratory laboratory, BindingResult bindingResult) {
        laboratoryService.save(laboratory);
        return "redirect:/index";

    }


    @GetMapping("/editLaboratory/{id}")
    public ModelAndView editlaboratory(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndVie = new ModelAndView("editLaboratory");
        Laboratory laboratory = laboratoryService.findById(id);
        modelAndVie.addObject("laboratory", laboratory);
        return modelAndVie;
    }

    @PostMapping(value = "/save")
    public String savelaboratory(@ModelAttribute("laboratory") Laboratory laboratory) {
        laboratoryService.save(laboratory);
        return "redirect:/index";
    }

    @PostMapping(value = "/saveEdit")
    public String saveEditlaboratory(@ModelAttribute("laboratory") Laboratory laboratory) {
        laboratoryService.saveEdit(laboratory);
        return "redirect:/index";
    }

    @RequestMapping("/deleteLaboratory/{sid}")
    public String deletelaboratory(@PathVariable (name="sid") Long sid) {
        laboratoryService.delete(sid);
        return "redirect:/index";
    }


    @GetMapping("/viewLaboratory/{id}")
    public ModelAndView viewLab(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndVie = new ModelAndView("viewLaboratory");
        Laboratory laboratory = laboratoryService.findById(id);
        modelAndVie.addObject("laboratory", laboratory);
        return modelAndVie;
    }
}
