package com.example.demo.entity
import jakarta.persistence.*;
import java.time.LocalDataTime;
@Entity
public class StudentProfile{
    @Id
    private long id;
    private String studentId;
    private String name;
    private String email;
    private String program;
    private int year; 
    private Boolean isRepeatOffender;
    private LocalDateTime createAt;

}
