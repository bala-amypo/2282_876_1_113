package com.example.demo.service;

import com.example.demo.entity.StudentProfile;
import java.util.List;

public interface StudentProfileService {
    StudentProfile createStudent(StudentProfile student);
    StudentProfile getStudentById(Long studentId);
    List<StudentProfile> getAllStudents();
    void updateRepeatOffenderStatus(Long studentId);
}
