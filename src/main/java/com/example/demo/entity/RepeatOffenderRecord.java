package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean repeatOffender;
    private String severityLevel;

    @OneToOne
    private StudentProfile studentProfile;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Boolean getRepeatOffender() { return repeatOffender; }
    public void setRepeatOffender(Boolean repeatOffender) { this.repeatOffender = repeatOffender; }

    public String getSeverityLevel() { return severityLevel; }
    public void setSeverityLevel(String severityLevel) { this.severityLevel = severityLevel; }

    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
}
