package com.example.pos_system.services;

import java.util.List;

import com.example.pos_system.dto.ReportDto;

public interface ReportService {
    ReportDto createReport(ReportDto reportDTO);
    List<ReportDto> getAllReports();
    ReportDto getReportById(int id);
    void deleteReport(int id);
}
