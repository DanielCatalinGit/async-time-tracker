package com.signing.dani.asynctimetracker.core.repository;

import com.signing.dani.asynctimetracker.core.model.TimeRecord;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {
    Optional<TimeRecord> findTopByEmployeeIdOrderByTimestampDesc(String employeeId);
}