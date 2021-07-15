package com.example.ilaboratory.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "laboratories")
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lid;
    @NotNull(message = "*Please provide laboratory title")
    private String ltitle;
    private LabNumber lno;
    @NotNull(message = "*Please provide laboratory data")
    private String ldate;
    private String lcurricula;
    private String ldescription;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "lab")
    private Set<Assignment> assignments = new HashSet<>();

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "laboratory")
    private Set<Attendance> attendances = new HashSet<>();


    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getLtitle() {
        return ltitle;
    }

    public void setLtitle(String ltitle) {
        this.ltitle = ltitle;
    }

    public LabNumber getLno() {
        return lno;
    }

    public void setLno(LabNumber lno) {
        this.lno = lno;
    }

    public String getLdate() {
        return ldate;
    }

    public void setLdate(String ldate) {
        this.ldate = ldate;
    }

    public String getLcurricula() {
        return lcurricula;
    }

    public void setLcurricula(String lcurricula) {
        this.lcurricula = lcurricula;
    }

    public String getLdescription() {
        return ldescription;
    }

    public void setLdescription(String ldescription) {
        this.ldescription = ldescription;
    }

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
}
