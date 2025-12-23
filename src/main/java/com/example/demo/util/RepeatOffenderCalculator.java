package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.RepeatOffenderRecord;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setSeverity(calculateSeverity(cases.size()));
        return record;
    }

    public boolean isRepeatOffender(List<IntegrityCase> cases) {
        return cases.size() > 1;
    }

    public int calculateSeverity(int numCases) {
        return Math.min(numCases * 10, 100);
    }
}
