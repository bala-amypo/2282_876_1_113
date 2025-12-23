package com.example.demo.service;

import com.example.demo.entity.RepeatOffenderRecord;

public interface RepeatOffenderRecordService {
    void refreshRepeatOffenderData(Long studentId);
    RepeatOffenderRecord getRepeatOffenderRecord(Long studentId);
}
