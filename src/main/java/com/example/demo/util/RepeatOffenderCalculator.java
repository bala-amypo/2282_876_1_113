package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;

import java.time.LocalDate;
import java.util.List;

public class RepeatOffenderCalculator {

    public boolean isRepeatOffender(List<IntegrityCase> cases) {
        return cases.size() >= 2;
    }

    public int calculateSeverity(int caseCount) {
        if (caseCount >= 5) return 3;
        if (caseCount >= 3) return 2;
        return 1;
    }

    public void computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        boolean repeat = isRepeatOffender(cases);
        student.setRepeatOffender(repeat);
    }

    public static long countRecentCases(List<IntegrityCase> cases, int months) {
        LocalDate cutoff = LocalDate.now().minusMonths(months);
        return cases.stream()
                .filter(c -> c.getIncidentDate() != null)
                .filter(c -> c.getIncidentDate().isAfter(cutoff))
                .count();
    }
}
