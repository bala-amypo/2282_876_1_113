package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repeat-offender")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
        this.service = service;
    }

    @PostMapping("/refresh/{studentId}")
    public RepeatOffenderRecord refreshRepeatOffenderData(@PathVariable Long studentId) {
        service.refreshRepeatOffenderData(studentId); // service method can remain void
        return service.getRepeatOffenderRecord(studentId); // return the updated record
    }
}
