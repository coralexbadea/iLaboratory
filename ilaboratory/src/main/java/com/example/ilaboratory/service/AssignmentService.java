package com.example.ilaboratory.service;

import com.example.ilaboratory.domain.Assignment;
import com.example.ilaboratory.domain.Laboratory;
import com.example.ilaboratory.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



public interface AssignmentService {

    public void save(Assignment a, Long id) ;
    public void save(Assignment a) ;
    public Assignment findById(Long id);

    public Assignment saveEdit(Assignment assignment);
    @Transactional
    public void delete(Long id) ;
    public List<Assignment> listAllByLabId(Long id) ;

}
