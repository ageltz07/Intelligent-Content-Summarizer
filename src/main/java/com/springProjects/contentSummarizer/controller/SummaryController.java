package com.springProjects.contentSummarizer.controller;

import com.springProjects.contentSummarizer.model.Summary;
import com.springProjects.contentSummarizer.repository.SummaryRepository;
import com.springProjects.contentSummarizer.utility.OpenAIApiClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class SummaryController {
    private OpenAIApiClient openAIApiClient;
    private SummaryRepository summaryRepository;

    public SummaryController(OpenAIApiClient openAIApiClient, SummaryRepository summaryRepository) {
        this.openAIApiClient = openAIApiClient;
        this.summaryRepository = summaryRepository;
    }

    public Summary generateSummary(String originalText) {
        String prompt = "Summarize the following text:\n\n" + originalText;
        String summaryText = openAIApiClient.getChatCompletion(prompt);

        Summary summary = new Summary();
        summary.setOriginalText(originalText);
        summary.setSummaryText(summaryText);
        summary.setCreatedAt(LocalDateTime.now());

        return summaryRepository.save(summary);
    }
}
