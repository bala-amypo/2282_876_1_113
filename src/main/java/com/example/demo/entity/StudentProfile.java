package com.example.demo.entity
import jakarta.persistence.*;
import java.time.LocalDataTime;
@Entity
public class StudentProfile{
    @Id
    private long id;
    @column(unique=true)
    private String studentId;
    private String name;
    @column(unique=true)
    private String email;
    private String program;
    private int year; 
    private Boolean isRepeatOffender;
    private LocalDateTime createAt;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Boolean getIsRepeatOffender() {
        return isRepeatOffender;
    }
    public void setIsRepeatOffender(Boolean isRepeatOffender) {
        this.isRepeatOffender = isRepeatOffender;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public StudentProfile(long id, String studentId, String name, String email, String program, int year,
            Boolean isRepeatOffender, LocalDateTime createAt) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.program = program;
        this.year = year;
        this.isRepeatOffender = isRepeatOffender;
        this.createAt = createAt;
    }
    public StudentProfile() {
    }
}

