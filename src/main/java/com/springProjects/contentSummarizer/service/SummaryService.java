package com.springProjects.contentSummarizer.service;

import com.springProjects.contentSummarizer.model.Summary;
import com.springProjects.contentSummarizer.repository.SummaryRepository;
import com.springProjects.contentSummarizer.utility.OpenAIApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SummaryService {

    private SummaryRepository summaryRepository;
    private OpenAIApiClient openAIApiClient;
    private String apiKey;

    public SummaryService(SummaryRepository summaryRepository, OpenAIApiClient openAIApiClient, @Value("${OpenAI.api.key}") String apiKey) {
        this.summaryRepository = summaryRepository;
        this.openAIApiClient = openAIApiClient;
        this.apiKey = apiKey;
    }

    public String getSummary(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4o-mini");
        requestBody.put("messages", List.of(Map.of("role", "user", "content", prompt)));

        String authorizationHeader = "Bearer " + apiKey;
        ResponseEntity<String> response = openAIApiClient.getChatCompletion("Bearer " + apiKey,requestBody);

        return response.getBody();
    }

    public Summary saveSummary(Summary summary) {
        summary.setCreatedAt(LocalDateTime.now());
        return summaryRepository.save(summary);
    }

    public List<Summary> getAllSummaries() {
        return summaryRepository.findAll();
    }
}
