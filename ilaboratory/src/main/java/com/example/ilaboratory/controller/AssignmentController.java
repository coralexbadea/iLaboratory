package com.example.ilaboratory.controller;

import com.example.ilaboratory.domain.Assignment;
import com.example.ilaboratory.domain.Submit;
import com.example.ilaboratory.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @GetMapping(value = "/index/{id}")
    public ModelAndView getassignments(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Assignment> assignments = assignmentService.listAllByLabId(id);
        modelAndView.addObject("assignments", assignments);
        modelAndView.addObject("id", id);
        modelAndView.setViewName("assignment/index");
        return modelAndView;
    }

    @GetMapping(value = "/create/{id}")
    public ModelAndView create(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("assignment/create");
        modelAndView.addObject("assignment", new Assignment());
        modelAndView.addObject( "lid", id);
        return modelAndView;
    }

    @PostMapping(value = "/create/{id}")
    public String create(@PathVariable(name = "id") Long id, @Valid Assignment assignment, Long _) {
        assignmentService.save(assignment, id);
        return "redirect:/assignment/index/"+ id;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndVie = new ModelAndView("assignment/edit");
        Assignment assignment = assignmentService.findById(id);
        modelAndVie.addObject("assignment", assignment);
        modelAndVie.addObject("lid", assignment.getLab().getLid());
        return modelAndVie;
    }

    @PostMapping(value = "/edit/{lid}")
    public String edit(@PathVariable(name = "lid") Long lid, @ModelAttribute("assignment") Assignment assignment) {
        assignmentService.saveEdit(assignment);
        return "redirect:/assignment/index/"+lid;
    }


    @RequestMapping("/delete/{lid}/{sid}")
    public String deletelaboratory(@PathVariable (name="sid") Long sid,@PathVariable (name="lid") Long lid) {
        assignmentService.delete(sid);
        return "redirect:/assignment/index/"+lid;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndVie = new ModelAndView("assignment/view");
        modelAndVie.addObject("assignment", assignmentService.findById(id));
        modelAndVie.addObject("submit", new Submit());
        return modelAndVie;
    }


}
