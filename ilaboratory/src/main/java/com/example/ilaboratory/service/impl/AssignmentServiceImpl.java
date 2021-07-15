package com.example.ilaboratory.service.impl;

import com.example.ilaboratory.domain.Assignment;
import com.example.ilaboratory.domain.Laboratory;
import com.example.ilaboratory.repository.AssignmentRepository;
import com.example.ilaboratory.service.AssignmentService;
import com.example.ilaboratory.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("assignmentService")
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;
    @Autowired
    LaboratoryService laboratoryService;

    public void save(Assignment a, Long id) {
        Laboratory lab = laboratoryService.findById(id);
        a.setLab(lab);
        assignmentRepository.save(a);


    }

    public void save(Assignment a) {
        assignmentRepository.save(a);

    }

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).get();
    }

    public Assignment saveEdit(Assignment assignment) {
        Assignment a = assignmentRepository.findById(assignment.getAid()).get();
        a.setDeadline(assignment.getDeadline());
        a.setName(assignment.getName());
        a.setDescription(assignment.getDescription());
        return assignmentRepository.save(a);
    }

    @Transactional
    public void delete(Long id) {

        assignmentRepository.deleteById(id);
    }
    public List<Assignment> listAllByLabId(Long id) {
        return assignmentRepository.findAllByLab_Lid(id);
    }
}
