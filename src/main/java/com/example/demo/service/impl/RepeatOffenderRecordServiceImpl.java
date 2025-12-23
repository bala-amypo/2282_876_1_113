package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository recordRepo;

    private final RepeatOffenderCalculator calculator = new RepeatOffenderCalculator();

    public RepeatOffenderRecordServiceImpl(
            StudentProfileRepository studentRepo,
            IntegrityCaseRepository caseRepo,
            RepeatOffenderRecordRepository recordRepo) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.recordRepo = recordRepo;
    }

    @Override
    public RepeatOffenderRecord generateRecord(Long studentId) {
        StudentProfile student = studentRepo.findById(studentId).orElseThrow();
        List<IntegrityCase> cases = caseRepo.findByStudentProfile(student);

        RepeatOffenderRecord record =
                calculator.computeRepeatOffenderRecord(student, cases);

        student.setRepeatOffender(record.getRepeatOffender());
        studentRepo.save(student);

        return recordRepo.save(record);
    }
}
