package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderCalculator;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
    private final StudentProfileRepository studentProfileRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final RepeatOffenderCalculator repeatOffenderCalculator;

    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository,
                                   IntegrityCaseRepository integrityCaseRepository,
                                   RepeatOffenderRecordRepository repeatOffenderRecordRepository,
                                   RepeatOffenderCalculator repeatOffenderCalculator) {
        this.studentProfileRepository = studentProfileRepository;
        this.integrityCaseRepository = integrityCaseRepository;
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
        this.repeatOffenderCalculator = repeatOffenderCalculator;
    }

    @Override
    public StudentProfile createStudent(StudentProfile studentProfile) {
        studentProfile.setRepeatOffender(false);
        return studentProfileRepository.save(studentProfile);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }

    @Override
    public StudentProfile updateRepeatOffenderStatus(Long studentId) {
        StudentProfile student = getStudentById(studentId);
        var cases = integrityCaseRepository.findByStudentProfile(student);
        
        int totalCases = cases.size();
        String severity = repeatOffenderCalculator.calculateSeverity(totalCases);
        boolean isRepeatOffender = repeatOffenderCalculator.isRepeatOffender(cases);
        
        student.setRepeatOffender(isRepeatOffender);
        
        RepeatOffenderRecord record = repeatOffenderRecordRepository.findByStudentProfile(student)
                .orElse(new RepeatOffenderRecord());
        record.setStudentProfile(student);
        record.setTotalCases(totalCases);
        record.setFlagSeverity(severity);
        
        if (!cases.isEmpty()) {
            record.setFirstIncidentDate(cases.get(0).getIncidentDate());
        }
        
        repeatOffenderRecordRepository.save(record);
        return studentProfileRepository.save(student);
    }
}