package com.springProjects.contentSummarizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContentSummarizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentSummarizerApplication.class, args);
	}

}
