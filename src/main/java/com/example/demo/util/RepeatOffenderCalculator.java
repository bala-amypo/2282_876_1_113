package com.example.demo.util;

import com.example.demo.entity.RepeatOffenderRecord;

public class RepeatOffenderCalculator {
    
    public void calculateAndSetSeverity(RepeatOffenderRecord record, int totalCases) {
        String severity;
        if (totalCases >= 4) {
            severity = "HIGH";
        } else if (totalCases >= 2) {
            severity = "MEDIUM";
        } else {
            severity = "LOW";
        }
        record.setFlagSeverity(severity);
    }
}
