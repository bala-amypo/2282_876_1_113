package com.example.demo.util;

import com.example.demo.entity.*;

import java.util.List;

public class RepeatOffenderCalculator {

    public boolean isRepeatOffender(List<IntegrityCase> cases) {
        return cases.size() >= 2;
    }

    public int calculateSeverity(int count) {
        if (count >= 5) return 3;
        if (count >= 3) return 2;
        return 1;
    }

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile student,
            List<IntegrityCase> cases) {

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setRepeatOffender(isRepeatOffender(cases));
        record.setSeverityLevel(
                String.valueOf(calculateSeverity(cases.size()))
        );
        return record;
    }
}
