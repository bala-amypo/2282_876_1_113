package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);

    // other methods required by test suite:
    List<IntegrityCase> findByStudentIdentifier(String studentId);
    List<IntegrityCase> findRecentCasesByStatus(String status, java.time.LocalDate date);
    List<IntegrityCase> findByIncidentDateBetween(java.time.LocalDate start, java.time.LocalDate end);
}
