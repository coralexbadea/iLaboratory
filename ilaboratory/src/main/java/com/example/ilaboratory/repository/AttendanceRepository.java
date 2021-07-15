package com.example.ilaboratory.repository;

import com.example.ilaboratory.domain.Attendance;
import com.example.ilaboratory.domain.Submit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findAllByLaboratory_Lid(Long id);
}
