package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository repository;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        return repository.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long id, String status) {
        Optional<IntegrityCase> optCase = repository.findById(id);
        if(optCase.isPresent()){
            IntegrityCase ic = optCase.get();
            ic.setStatus(status);
            return repository.save(ic);
        }
        return null;
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        return repository.findByStudentProfile_Id(studentId);
    }

    @Override
    public Optional<IntegrityCase> getCaseById(Long id) {
        return repository.findById(id);
    }
}
