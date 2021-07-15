package com.example.ilaboratory.service.impl;


import com.example.ilaboratory.domain.*;
import com.example.ilaboratory.repository.SubmitRepository;
import com.example.ilaboratory.service.AssignmentService;
import com.example.ilaboratory.service.StudentService;
import com.example.ilaboratory.service.SubmitService;
import com.example.ilaboratory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service("submitService")
public class SubmitServiceImpl implements SubmitService {
    @Autowired
    AssignmentService assignmentService;
    @Autowired
    SubmitRepository submitRepository;
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    public List<Submit> listAllByAssignmentId(Long id) {
        User user = userService.getCurrentUser();
        Iterator<Role> it = user.getRoles().iterator();
        while(it.hasNext()){
            if(it.next().getRoleName().equals("STUDENT"))
                return submitRepository.findAllByAssignment_AidAndStudent1_Sid(id, user.getStudent().getSid());
        }
        return submitRepository.findAllByAssignment_Aid(id);
    }

    public void save(Submit submit, Long id) {
        Assignment assignment = assignmentService.findById(id);
        User user = userService.getCurrentUser();
        Student student = user.getStudent();
        submit.setStudent(student);
        submit.setAssignment(assignment);
        submitRepository.save(submit);

    }

    public Submit findById(Long id) {
        return submitRepository.findById(id).get();
    }

    public void grade(Long id, int grade) {
        Submit submit1 = findById(id);
        submit1.setGrade(grade);
        submitRepository.save(submit1);
    }

    @Transactional
    public void delete(Long id) {
        submitRepository.deleteById(id);
    }
}
