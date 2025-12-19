package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import java.util.List;

public interface StudentProfileService {

    StudentProfile createStudent(StudentProfile dto);

    StudentProfile getStudentById(Long id);

    List<StudentProfile> getAllStudents();

    void updateRepeatOffenderStatus(Long studentId);
}
