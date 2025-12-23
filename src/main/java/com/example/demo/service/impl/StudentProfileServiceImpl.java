package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.util.RepeatOffenderCalculator;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderCalculator calculator;

    public StudentProfileServiceImpl(StudentProfileRepository studentRepo, IntegrityCaseRepository caseRepo,
                                     RepeatOffenderCalculator calculator) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.calculator = calculator;
    }

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        return studentRepo.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void updateRepeatOffenderStatus(Long studentId) {
        StudentProfile student = studentRepo.findById(studentId).orElse(null);
        if(student != null){
            boolean repeat = calculator.isRepeatOffender(caseRepo.findByStudentProfile_Id(studentId));
            student.setRepeatOffender(repeat);
            studentRepo.save(student);
        }
    }
}
