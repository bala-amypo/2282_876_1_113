package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/evidence")
public class EvidenceRecordController {

    private final EvidenceRecordService evidenceRecordService;

    public EvidenceRecordController(EvidenceRecordService evidenceRecordService) {
        this.evidenceRecordService = evidenceRecordService;
    }

    @GetMapping("/{studentIdentifier}")
    public List<IntegrityCase> getCases(@PathVariable String studentIdentifier) {
        return evidenceRecordService.getCasesByStudentIdentifier(studentIdentifier);
    }
}
