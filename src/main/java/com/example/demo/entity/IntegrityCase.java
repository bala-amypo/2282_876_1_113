package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class IntegrityCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String studentIdentifier;
    private LocalDate incidentDate;

    @ManyToOne
    private StudentProfile studentProfile;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStudentIdentifier() { return studentIdentifier; }
    public void setStudentIdentifier(String studentIdentifier) { this.studentIdentifier = studentIdentifier; }

    public LocalDate getIncidentDate() { return incidentDate; }
    public void setIncidentDate(LocalDate incidentDate) { this.incidentDate = incidentDate; }

    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
}
