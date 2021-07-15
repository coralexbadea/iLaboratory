package com.example.ilaboratory.service;

import com.example.ilaboratory.domain.Laboratory;
import java.util.List;


public interface LaboratoryService {

    public List<Laboratory> listAll() ;

    public void save(Laboratory laboratory) ;

    public Laboratory findById(Long id);

    public Laboratory saveEdit(Laboratory laboratory);

    public void delete(Long sid);
}
