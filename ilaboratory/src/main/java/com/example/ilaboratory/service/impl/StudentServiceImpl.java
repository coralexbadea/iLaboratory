package com.example.ilaboratory.service.impl;

import com.example.ilaboratory.domain.Laboratory;
import com.example.ilaboratory.domain.Student;
import com.example.ilaboratory.repository.StudentRepository;
import com.example.ilaboratory.service.Constants;
import com.example.ilaboratory.service.StudentService;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;


@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private Constants cons;
    @Autowired
    StudentRepository studentRepository;
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public void save(Student s) {
        studentRepository.save(s);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void createStudent(Student student){
        String token = createUniqueToket();
        student.setToken(token);
        save(student);
    }

    private String createUniqueToket() {
        String SALTCHARS = cons.getCharSet();
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < cons.getTokenSize()) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public Student saveEdit(Student student) {
        Student s = studentRepository.findById(student.getSid()).get();
        student.setToken(s.getToken());
        return studentRepository.save(student);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }

    public Student findStudentByToken(String token) {
        return studentRepository.findByToken(token);
    }
}
