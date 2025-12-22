package com.example.demo.dto;

public class StudentRequests {

    private String studentId;
    private String email;
    private String name;
    private String program;
    private Integer yearLevel;
    private Boolean repeatOffender;

    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public Integer getYearLevel() {
        return yearLevel;
    }

    public Boolean getRepeatOffender() {
        return repeatOffender;
    }
}
