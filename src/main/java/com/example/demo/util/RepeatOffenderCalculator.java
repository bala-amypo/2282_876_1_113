package com.example.demo.util;

import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;

import java.time.LocalDate;
import java.util.List;

public class RepeatOffenderCalculator {

    public boolean isRepeatOffender(List<IntegrityCase> cases) {
        return cases != null && cases.size() >= 2;
    }

    public String calculateSeverity(int totalCases) {
        if (totalCases == 1) return "LOW";
        if (totalCases == 2) return "MEDIUM";
        if (totalCases >= 4) return "HIGH";
        return "LOW";
    }

    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile s, List<IntegrityCase> cases) {

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(s);
        record.setTotalCases(cases.size());

        if (!cases.isEmpty()) {
            record.setLastIncidentDate(
                    cases.stream()
                            .map(IntegrityCase::getIncidentDate)
                            .max(LocalDate::compareTo)
                            .orElse(null)
            );
        }

        record.setFlagSeverity(calculateSeverity(cases.size()));
        return record;
    }
}
