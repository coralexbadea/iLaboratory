package com.example.ilaboratory.repository;

import com.example.ilaboratory.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByToken(String token);
}
