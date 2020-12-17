package com.webspoon.snippet.controller;

import com.webspoon.snippet.pojo.*;
import com.webspoon.snippet.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("snippets")
public class StoreController {

    @Autowired
    SnippetService snippetService;

    @PostMapping()
    public ResponseEntity<SnippetResponse> storeSnippet(@RequestBody SnippetRequest snippetRequest){
        ResponseEntity<SnippetResponse> Resp;
        SnippetResponse resp = snippetService.store(snippetRequest);
        if(resp.getName() != null){
            Resp = new ResponseEntity<SnippetResponse>(resp, HttpStatus.CREATED);
        }else {
            Resp = new ResponseEntity<SnippetResponse>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return Resp;
    }

    @GetMapping("{snippetName}")
    public ResponseEntity<SnippetResponse> readSnippet(@PathVariable String snippetName){
        ResponseEntity<SnippetResponse> Resp;
        SnippetResponse resp = snippetService.read(snippetName);
        if(resp.getName() != null){
            Resp = new ResponseEntity<SnippetResponse>(resp, HttpStatus.OK);
        }else {
            Resp = new ResponseEntity<SnippetResponse>(HttpStatus.NOT_FOUND);
        }
        return Resp;
    }

    @GetMapping("{snippetName}/like")
    public ResponseEntity<SnippetResponse> likeSnippet(@PathVariable String snippetName){
        ResponseEntity<SnippetResponse> Resp;
        SnippetResponse resp = snippetService.read(snippetName);
        if(resp.getName() != null){
            resp = snippetService.storeWithLikes(resp);
            Resp = new ResponseEntity<SnippetResponse>(resp, HttpStatus.OK);
        }else {
            Resp = new ResponseEntity<SnippetResponse>(HttpStatus.NOT_FOUND);
        }
        return Resp;
    }
}
