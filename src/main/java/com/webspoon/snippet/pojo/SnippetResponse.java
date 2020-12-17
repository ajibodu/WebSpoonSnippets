package com.webspoon.snippet.pojo;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.Date;

public class SnippetResponse {
    private String url;
    private String name;
    private Date expires_at;
    private String snippet;
    private Integer likes;

    private Date getExpiryDateTime(int addSeconds){
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(new Date());               // sets calendar time/date
        cal.add(Calendar.SECOND, addSeconds);      // adds one hour
        return cal.getTime();
    }
    private String getURL(String name){
        String url = "";
        try {
            InetAddress ia = InetAddress.getLocalHost();
            url = ia.getHostName().concat("/snippets/").concat(name);
        }catch (Exception e){}
        return url;
    }
    public SnippetResponse(){}
    public SnippetResponse(String url, String name, int expires_in, String snippet, Integer like) {
        this.url = getURL(name);
        this.name = name;
        this.expires_at = getExpiryDateTime(expires_in);
        this.snippet = snippet;
        this.likes = like;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}

