package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {
    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
        this.service = service;
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<ApiResponse> recalculateRecord(@PathVariable Long studentId) {
        RepeatOffenderRecord record = service.recalculateRecord(studentId);
        return ResponseEntity.ok(new ApiResponse(true, "Record recalculated", record));
    }
}