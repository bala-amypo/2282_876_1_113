package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final IntegrityCaseRepository integrityCaseRepository;

    public EvidenceRecordServiceImpl(IntegrityCaseRepository integrityCaseRepository) {
        this.integrityCaseRepository = integrityCaseRepository;
    }

    @Override
    public List<IntegrityCase> getCasesByStudentIdentifier(String studentIdentifier) {
        return integrityCaseRepository.findByStudentIdentifier(studentIdentifier);
    }
}
