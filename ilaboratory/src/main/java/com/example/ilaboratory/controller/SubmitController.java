package com.example.ilaboratory.controller;

import com.example.ilaboratory.domain.Submit;
import com.example.ilaboratory.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/submit")
public class SubmitController {
    @Autowired
    SubmitService submitService;

    @GetMapping(value = "/index/{id}")
    public ModelAndView getsubmits(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Submit> submits = submitService.listAllByAssignmentId(id);
        modelAndView.addObject("submits", submits);
        modelAndView.addObject("id", id);
        modelAndView.setViewName("submit/index");
        return modelAndView;
    }


    @PostMapping(value = "/create/{id}")
    public String create(@PathVariable(name = "id") Long id, @Valid Submit submit) {
        submitService.save(submit, id);
        return "redirect:/assignment/view/"+ id;
    }

    @RequestMapping("/delete/{aid}/{sid}")
    public String deletesubmit(@PathVariable (name="sid") Long sid,@PathVariable (name="aid") Long aid) {
        submitService.delete(sid);
        return "redirect:/submit/index/"+aid;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndVie = new ModelAndView("submit/view");
        modelAndVie.addObject("submit", submitService.findById(id));
        return modelAndVie;
    }

    @PostMapping(value = "/grade/{id}")
    public String grade(@PathVariable(name = "id") Long id, @Valid Submit submit) {
        submitService.grade(id, submit.getGrade());
        return "redirect:/submit/view/"+id;
    }


}
