package com.victoriaejeh.moviesproject.model;

import java.util.List;

public class MoviesResponse {

    private final List<MovieResponse> movies;

    public MoviesResponse(List<MovieResponse> m) {
        this.movies = m;
    }

    public List<MovieResponse> getMovies() {
        return movies;
    }
}
