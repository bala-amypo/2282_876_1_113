package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile_Id(Long studentId);

    List<IntegrityCase> findByStatus(String status);

    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.status = :status AND ic.incidentDate >= :since")
    List<IntegrityCase> findRecentCasesByStatus(
            @Param("status") String status,
            @Param("since") LocalDate since
    );
}
