package com.example.ilaboratory.repository;


import com.example.ilaboratory.domain.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    public List<Assignment> findAllByLab_Lid(Long id);
}
