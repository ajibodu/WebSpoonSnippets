package com.webspoon.snippet.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SnippetRequest {
    private String name;
    private Integer expires_in;
    private String snippet;
    private String likes;

    @JsonIgnore
    public String getLikes() {
        return likes;
    }

    @JsonIgnore
    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}

