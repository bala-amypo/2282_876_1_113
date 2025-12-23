package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.stereotype.Service;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {
    private final EvidenceRecordRepository evidenceRecordRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    
    public EvidenceRecordServiceImpl(EvidenceRecordRepository evidenceRecordRepository,
                                   IntegrityCaseRepository integrityCaseRepository) {
        this.evidenceRecordRepository = evidenceRecordRepository;
        this.integrityCaseRepository = integrityCaseRepository;
    }
    
    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidenceRecord) {
        if (evidenceRecord.getIntegrityCase() == null || 
            !intpackage com.example.demo.service.impl;

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

    public List<IntegrityCase> getCasesByStudentIdentifier(String studentIdentifier) {
        return integrityCaseRepository.findByStudentIdentifier(studentIdentifier);
    }
}
egrityCaseRepository.existsById(evidenceRecord.getIntegrityCase().getId())) {
            throw new ResourceNotFoundException("IntegrityCase not found");
        }
        return evidenceRecordRepository.save(evidenceRecord);
    }
}
