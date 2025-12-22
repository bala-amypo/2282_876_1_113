package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String studentId;

    @Column(unique = true)
    private String email;

    private String name;
    private String program;
    private Integer yearLevel;
    private Boolean isRepeatOffender;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public Boolean getIsRepeatOffender() { return isRepeatOffender; }
    public void setIsRepeatOffender(Boolean isRepeatOffender) { this.isRepeatOffender = isRepeatOffender; }
}
