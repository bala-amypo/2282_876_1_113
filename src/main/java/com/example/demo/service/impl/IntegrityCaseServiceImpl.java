package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository repository;
    private final StudentProfileRepository studentRepo;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository repository,
                                    StudentProfileRepository studentRepo) {
        this.repository = repository;
        this.studentRepo = studentRepo;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        return repository.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String status) {
        IntegrityCase ic = repository.findById(caseId).orElseThrow();
        ic.setStatus(status);
        return repository.save(ic);
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        StudentProfile student = studentRepo.findById(studentId).orElseThrow();
        return repository.findByStudentProfile(student);
    }

    @Override
    public IntegrityCase getCaseById(Long caseId) {
        return repository.findById(caseId).orElseThrow();
    }
}
