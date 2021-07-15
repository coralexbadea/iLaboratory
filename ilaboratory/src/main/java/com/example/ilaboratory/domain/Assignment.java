package com.example.ilaboratory.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;
    private String name;
    private String deadline;
    private String description;
    @ManyToOne
    @JoinColumn(name="lid")
    private Laboratory lab;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "assignment")
    private Set<Submit> submits = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Laboratory getLab() {
        return lab;
    }

    public void setLab(Laboratory lab) {
        this.lab = lab;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Set<Submit> getSubmits() {
        return submits;
    }

    public void setSubmits(Set<Submit> submits) {
        this.submits = submits;
    }
}
