package com.example.pos_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos_system.dto.ReportDto;
import com.example.pos_system.services.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<ReportDto> createReport(@RequestBody ReportDto reportDTO) {
        return ResponseEntity.ok(reportService.createReport(reportDTO));
    }

    @GetMapping
    public ResponseEntity<List<ReportDto>> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDto> getReportById(@PathVariable int id) {
        return ResponseEntity.ok(reportService.getReportById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReport(@PathVariable int id) {
        reportService.deleteReport(id);
        return ResponseEntity.ok("Report deleted successfully");
    }
}
