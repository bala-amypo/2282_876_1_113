package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import java.util.List;

/**
 * Test adapter that extends the service calculator and provides the legacy
 * computeRepeatOffenderRecord API expected by some tests.
 * This class intentionally has no Spring annotations to avoid bean name clashes.
 */
public class RepeatOffenderCalculator extends com.example.demo.service.RepeatOffenderCalculator {

    /**
     * Builds a RepeatOffenderRecord from a student and their cases using the
     * severity calculation from the parent service calculator.
     */
    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile studentProfile,
                                                            List<IntegrityCase> cases) {
        int totalCases = (cases == null) ? 0 : cases.size();
        String severity = calculateSeverity(totalCases);

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(studentProfile);
        record.setTotalCases(totalCases);
        record.setFlagSeverity(severity);
        return record;
    }
}
