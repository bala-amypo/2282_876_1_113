package com.example.demo.service;

import com.example.demo.entity.IntegrityCase;
import java.util.List;

public interface EvidenceRecordService {
    List<IntegrityCase> getCasesByStudentIdentifier(String studentIdentifier);
}
