package com.springProjects.contentSummarizer.repository;

import com.springProjects.contentSummarizer.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
    // custom query methods go here.
}
