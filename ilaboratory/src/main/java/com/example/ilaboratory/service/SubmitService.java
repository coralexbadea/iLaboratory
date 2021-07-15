package com.example.ilaboratory.service;


import com.example.ilaboratory.domain.*;
import com.example.ilaboratory.repository.SubmitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;


public interface SubmitService {

    public List<Submit> listAllByAssignmentId(Long id);

    public void save(Submit submit, Long id);

    public Submit findById(Long id);

    public void grade(Long id, int grade) ;
    @Transactional
    public void delete(Long id);
}
