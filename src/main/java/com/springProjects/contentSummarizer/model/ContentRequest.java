package com.springProjects.contentSummarizer.model;

public class ContentRequest {
    private String content;

    public ContentRequest() {}

    public ContentRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
