package com.victoriaejeh.moviesproject.model;


public class MovieIdResponse {

    private final String id;

    public MovieIdResponse(Long id) {
        this.id = id.toString();
    }

    public String getId() {
        return id;
    }
}
