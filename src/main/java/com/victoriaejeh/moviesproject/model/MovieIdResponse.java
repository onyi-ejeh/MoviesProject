package com.victoriaejeh.moviesproject.model;

/**
 * Represents a response containing the identifier of a movie.
 * <p>
 * This class is used to encapsulate the movie's id in response payloads.
 * </p>
 */
public class MovieIdResponse {

    /**
     * The unique identifier of the movie as a String.
     */
    private final String id;

    /**
     * Constructs a MovieIdResponse with the given movie id.
     *
     * @param id the unique identifier of the movie
     */
    public MovieIdResponse(Long id) {
        this.id = id.toString();
    }

    /**
     * Returns the movie's unique identifier.
     *
     * @return the id of the movie as a String
     */
    public String getId() {
        return id;
    }
}
