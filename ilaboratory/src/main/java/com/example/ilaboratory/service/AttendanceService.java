package com.example.ilaboratory.service;

import com.example.ilaboratory.domain.*;

import java.util.List;


public interface AttendanceService {

    public List<Attendance> listAllByLabId(Long id);
    public void save(Attendance attendance, Long id) ;

}
