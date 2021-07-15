package com.example.ilaboratory.service;

import com.example.ilaboratory.domain.Student;
import java.util.List;



public interface StudentService {
    public List<Student> listAll();
    public Student findById(Long id);
    public void save(Student s);
    public void createStudent(Student student);
    public Student saveEdit(Student student);
    public void delete(Long id);
    public Student findStudentByToken(String token);

}
