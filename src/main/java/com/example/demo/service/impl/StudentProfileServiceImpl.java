package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        student.setRepeatOffender(false);
        return repository.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long studentId) {
        return repository.findById(studentId).orElseThrow();
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void updateRepeatOffenderStatus(Long studentId) {
        StudentProfile student = repository.findById(studentId).orElseThrow();
        student.setRepeatOffender(!Boolean.TRUE.equals(student.getRepeatOffender()));
        repository.save(student);
    }
}
