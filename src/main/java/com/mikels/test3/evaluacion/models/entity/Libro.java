package com.mikels.test3.evaluacion.models.entity;

import com.fasterxml.jackson.annotation.*;

public class Libro {
    private long userID;
    private long id;
    private String title;
    private String body;

    @JsonProperty("userId")
    public long getUserID() {
        return userID;
    }

    @JsonProperty("userId")
    public void setUserID(long value) {
        this.userID = value;
    }

    @JsonProperty("id")
    public long getID() {
        return id;
    }

    @JsonProperty("id")
    public void setID(long value) {
        this.id = value;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String value) {
        this.title = value;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String value) {
        this.body = value;
    }
}