package com.webspoon.snippet.service;

import com.webspoon.snippet.pojo.SnippetRequest;
import com.webspoon.snippet.pojo.SnippetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "Snippets")
public class SnippetService {

    @Autowired
    CacheManager cacheManager;

    @CachePut(key = "#snippetRequest.name")
    public SnippetResponse store(SnippetRequest snippetRequest){
        SnippetResponse snippetResponse = new SnippetResponse(
                snippetRequest.getName(),
                snippetRequest.getName(),
                snippetRequest.getExpires_in(),
                snippetRequest.getSnippet(),
                0
        );
        return snippetResponse;
    }

    @CachePut(key = "#snippet.name")
    public SnippetResponse storeWithLikes(SnippetResponse snippet){
        SnippetResponse snippetResponse = new SnippetResponse(
                snippet.getName(),
                snippet.getName(),
                30,
                snippet.getSnippet(),
                snippet.getLikes() + 1
        );
        return snippetResponse;
    }

    @Cacheable(key = "#snippetName")
    public SnippetResponse read(String snippetName){
        return new SnippetResponse();
    }

    @Scheduled(initialDelay = 30000, fixedRate = 30000)
    public void evictAllcacheAtIntervals() {
        evictAllCaches();
    }

    public void evictAllCaches() {
        cacheManager.getCacheNames().stream()
                .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }


}
