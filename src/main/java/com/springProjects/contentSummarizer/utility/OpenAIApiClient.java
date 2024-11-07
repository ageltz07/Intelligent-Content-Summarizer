package com.springProjects.contentSummarizer.utility;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "openAIApiClient", url = "${OpenAI.api.url}")
public interface OpenAIApiClient {

    @PostMapping("/v1/chat/completions")
    ResponseEntity<String> getChatCompletion(
            @RequestHeader("Authorization") String authorization,
            @RequestBody Map<String, Object> requestBody
    );
}
