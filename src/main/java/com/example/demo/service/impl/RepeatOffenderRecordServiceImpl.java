package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.util.RepeatOffenderCalculator;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final RepeatOffenderRecordRepository recordRepo;
    private final StudentProfileRepository studentRepo;
    private final RepeatOffenderCalculator calculator;

    public RepeatOffenderRecordServiceImpl(RepeatOffenderRecordRepository recordRepo,
                                           StudentProfileRepository studentRepo,
                                           RepeatOffenderCalculator calculator) {
        this.recordRepo = recordRepo;
        this.studentRepo = studentRepo;
        this.calculator = calculator;
    }

    @Override
    public void refreshRepeatOffenderData(Long studentId) {
        StudentProfile student = studentRepo.findById(studentId).orElse(null);
        if(student != null){
            List cases = student.getCases();
            RepeatOffenderRecord record = calculator.computeRepeatOffenderRecord(student, cases);
            recordRepo.save(record);
            student.setRepeatOffender(calculator.isRepeatOffender(cases));
            studentRepo.save(student);
        }
    }

    @Override
    public RepeatOffenderRecord getRepeatOffenderRecord(Long studentId) {
        return recordRepo.findAll()
                .stream()
                .filter(r -> r.getStudentProfile().getId().equals(studentId))
                .findFirst()
                .orElse(null);
    }
}
