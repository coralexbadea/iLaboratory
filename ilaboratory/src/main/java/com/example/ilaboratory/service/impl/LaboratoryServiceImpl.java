package com.example.ilaboratory.service.impl;

import com.example.ilaboratory.domain.Laboratory;
import com.example.ilaboratory.repository.LaboratoryRepository;
import com.example.ilaboratory.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("laboratoryService")
public class LaboratoryServiceImpl implements LaboratoryService {
    @Autowired
    LaboratoryRepository laboratoryRepository;


    public List<Laboratory> listAll() {
        return laboratoryRepository.findAll();
    }

    public void save(Laboratory laboratory) {
        laboratoryRepository.save(laboratory);
    }

    public Laboratory findById(Long id) {
        return laboratoryRepository.findById(id).get();
    }

    public Laboratory saveEdit(Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }

    public void delete(Long sid) {
        laboratoryRepository.delete(laboratoryRepository.findById(sid).get());
    }
}
