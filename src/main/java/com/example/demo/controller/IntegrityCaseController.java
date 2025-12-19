package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class IntegrityCaseController {

    private final IntegrityCaseService integrityCaseService;

    public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
        this.integrityCaseService = integrityCaseService;
    }

    @PostMapping
    public ResponseEntity<IntegrityCase> createCase(
            @RequestBody IntegrityCase integrityCase
    ) {
        return ResponseEntity.ok(
                integrityCaseService.createCase(integrityCase)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntegrityCase> getCaseById(@PathVariable Long id) {
        return integrityCaseService.getCaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(
                integrityCaseService.getCasesByStudent(studentId)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<IntegrityCase> updateCaseStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(
                integrityCaseService.updateCaseStatus(id, status)
        );
    }
}
