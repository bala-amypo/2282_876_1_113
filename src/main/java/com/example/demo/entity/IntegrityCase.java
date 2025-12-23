package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentIdentifier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public void setStudentIdentifier(String studentIdentifier) {
        this.studentIdentifier = studentIdentifier;
    }
}
