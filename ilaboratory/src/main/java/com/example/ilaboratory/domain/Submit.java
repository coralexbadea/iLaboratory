package com.example.ilaboratory.domain;

import javax.persistence.*;

@Entity
@Table(name="submits")
public class Submit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String link;
    private String comment;
    private int grade;
    @ManyToOne
    @JoinColumn(name="aid")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name="sid")
    private Student student1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Student getStudent() {
        return student1;
    }

    public void setStudent(Student student) {
        this.student1 = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
