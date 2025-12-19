package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
        this.service = service;
    }

    // POST /refresh/{studentId}
    // Recalculate repeat-offender status
    @PostMapping("/refresh/{studentId}")
    public RepeatOffenderRecord refreshRepeatOffenderStatus(
            @PathVariable Long studentId) {
        return service.refreshStatus(studentId);
    }

    // GET /student/{studentId}
    // Get repeat-offender record for a student
    @GetMapping("/student/{studentId}")
    public RepeatOffenderRecord getByStudentId(
            @PathVariable Long studentId) {
        return service.getByStudentId(studentId);
    }

    // GET /
    // List all repeat offenders
    @GetMapping
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return service.getAll();
    }
}
