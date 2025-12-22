package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentProfileRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final RepeatOffenderCalculator repeatOffenderCalculator;

    public RepeatOffenderRecordServiceImpl(
            StudentProfileRepository studentProfileRepository,
            IntegrityCaseRepository integrityCaseRepository,
            RepeatOffenderRecordRepository repeatOffenderRecordRepository,
            RepeatOffenderCalculator repeatOffenderCalculator
    ) {
        this.studentProfileRepository = studentProfileRepository;
        this.integrityCaseRepository = integrityCaseRepository;
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
        this.repeatOffenderCalculator = repeatOffenderCalculator;
    }

    @Override
    public RepeatOffenderRecord refreshRepeatOffenderData(Long studentId) {

        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<IntegrityCase> cases = integrityCaseRepository.findByStudentProfile(student);

        if (cases.size() < 2) {
            return null;
        }

        RepeatOffenderRecord record =
                repeatOffenderCalculator.computeRepeatOffenderRecord(student, cases);

        return repeatOffenderRecordRepository.save(record);
    }

    @Override
    public RepeatOffenderRecord getRecordByStudent(Long studentId) {

        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return repeatOffenderRecordRepository.findByStudentProfile(student)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return repeatOffenderRecordRepository.findAll();
    }
}
