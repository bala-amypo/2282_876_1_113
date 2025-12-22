package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repeat-offender-records")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService repeatOffenderRecordService;

    public RepeatOffenderRecordController(RepeatOffenderRecordService repeatOffenderRecordService) {
        this.repeatOffenderRecordService = repeatOffenderRecordService;
    }
    @PostMapping("/recalculate/{studentId}")
    public RepeatOffenderRecord recalculate(@PathVariable Long studentId) {
        return repeatOffenderRecordService.refreshRepeatOffenderData(studentId);
    }
}
