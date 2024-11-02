package com.springProjects.contentSummarizer.service;

import com.springProjects.contentSummarizer.model.Summary;
import com.springProjects.contentSummarizer.repository.SummaryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SummaryService {

    private SummaryRepository summaryRepository;

    public SummaryService(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    public Summary saveSummary(Summary summary) {
        summary.setCreatedAt(LocalDateTime.now());
        return summaryRepository.save(summary);
    }

    public List<Summary> getAllSummaries() {
        return summaryRepository.findAll();
    }
}
