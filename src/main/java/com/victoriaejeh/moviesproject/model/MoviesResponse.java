package com.victoriaejeh.moviesproject.model;

import java.util.List;

/**
 * Represents a response model containing a list of movies.
 * <p>
 * This class encapsulates a collection of MovieResponse objects that can be returned
 * as a response to a request for multiple movies.
 * </p>
 */
public class MoviesResponse {

    /**
     * The list of movie responses.
     */
    private final List<MovieResponse> movies;

    /**
     * Constructs a MoviesResponse with the given list of movie responses.
     *
     * @param m the list of MovieResponse objects
     */
    public MoviesResponse(List<MovieResponse> m) {
        this.movies = m;
    }

    /**
     * Returns the list of movie responses.
     *
     * @return a list of MovieResponse objects
     */
    public List<MovieResponse> getMovies() {
        return movies;
    }
}
