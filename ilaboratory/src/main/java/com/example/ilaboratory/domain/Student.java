package com.example.ilaboratory.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @NotNull(message = "*Please provide the full")
    private String fullName;

    @NotNull(message = "*Please provide the email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email be valid")
    private String email;

    @NotNull(message = "*Please provide the address")
    private String address;

    private GroupNumber sGroup;

    private String hobby;
    private String token;

    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true ,mappedBy = "student")
    private User user;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "student1")
    private Set<Submit> submits = new HashSet<>();

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "student2")
    private Set<Attendance> attendances = new HashSet<>();

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GroupNumber getsGroup() {
        return sGroup;
    }

    public void setsGroup(GroupNumber sGroup) {
        this.sGroup = sGroup;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Submit> getSubmits() {
        return submits;
    }

    public void setSubmits(Set<Submit> submits) {
        this.submits = submits;
    }

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
}
