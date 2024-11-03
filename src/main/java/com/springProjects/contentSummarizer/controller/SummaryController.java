package com.springProjects.contentSummarizer.controller;

import com.springProjects.contentSummarizer.model.ContentRequest;
import com.springProjects.contentSummarizer.model.Summary;
import com.springProjects.contentSummarizer.repository.SummaryRepository;
import com.springProjects.contentSummarizer.service.SummaryService;
import com.springProjects.contentSummarizer.utility.OpenAIApiClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class SummaryController {
    private SummaryRepository summaryRepository;
    private SummaryService summaryService;

    public SummaryController(SummaryRepository summaryRepository, SummaryService summaryService) {
        this.summaryService = summaryService;
        this.summaryRepository = summaryRepository;
    }

    @PostMapping(value = "/summarize", consumes = "application/json", produces = "application/json")
    public Summary generateSummary(@RequestBody ContentRequest request) {
        String prompt = "Summarize the following text:\n\n" + request.getContent();
        String summaryText = summaryService.getSummary(prompt);

        Summary summary = new Summary();
        summary.setOriginalText(prompt);
        summary.setSummaryText(summaryText);
        summary.setCreatedAt(LocalDateTime.now());

        return summaryRepository.save(summary);
    }
}
