package com.signing.dani.asynctimetracker.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "time_records")
public class TimeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private LocalDateTime timestamp;
    private String recordType;

    public TimeRecord() {}

    public TimeRecord(String employeeId, LocalDateTime timestamp, String recordType) {
        this.employeeId = employeeId;
        this.timestamp = timestamp;
        this.recordType = recordType;
    }

    public Long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getRecordType() { return recordType; }
}