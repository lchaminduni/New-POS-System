package com.example.pos_system.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos_system.dto.ReportDto;
import com.example.pos_system.entity.Report;
import com.example.pos_system.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ReportDto createReport(ReportDto reportDTO) {
        Report report = modelMapper.map(reportDTO, Report.class);
        report = reportRepository.save(report);
        return modelMapper.map(report, ReportDto.class);
    }

    @Override
    public List<ReportDto> getAllReports() {
        return reportRepository.findAll()
                .stream()
                .map(report -> modelMapper.map(report, ReportDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReportDto getReportById(int id) {
        Report report = reportRepository.findById(id).orElseThrow(() -> new RuntimeException("Report not found"));
        return modelMapper.map(report, ReportDto.class);
    }

    @Override
    public void deleteReport(int id) {
        reportRepository.deleteById(id);
    }
}
