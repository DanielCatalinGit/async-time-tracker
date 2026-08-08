package com.signing.dani.asynctimetracker.core.repository;

import com.signing.dani.asynctimetracker.core.model.TimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {
}