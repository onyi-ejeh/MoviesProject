package com.victoriaejeh.moviesproject.service;

import com.victoriaejeh.moviesproject.model.MovieIdResponse;
import com.victoriaejeh.moviesproject.model.MovieRequest;
import com.victoriaejeh.moviesproject.model.MovieResponse;
import com.victoriaejeh.moviesproject.model.MoviesResponse;

/**
 * Service interface for managing movies.
 * <p>
 * This interface defines operations for creating, retrieving, updating, and deleting movies.
 * </p>
 */
public interface MoviesService {

    /**
     * Creates a new movie.
     *
     * @param movieRequest the request containing movie details
     * @return a MovieIdResponse with the identifier of the created movie
     */
    MovieIdResponse createMovie(MovieRequest movieRequest);

    /**
     * Retrieves all movies.
     *
     * @return a MoviesResponse containing a list of movie responses
     */
    MoviesResponse getMovies();

    /**
     * Retrieves a movie by its identifier.
     *
     * @param movieId the identifier of the movie to retrieve
     * @return a MovieResponse with the movie details
     */
    MovieResponse getMovie(Long movieId);

    /**
     * Updates an existing movie.
     *
     * @param movieId      the identifier of the movie to update
     * @param movieRequest the request containing updated movie details
     * @return a MovieIdResponse with the identifier of the updated movie
     */
    MovieIdResponse updateMovie(Long movieId, MovieRequest movieRequest);

    /**
     * Deletes a movie by its identifier.
     *
     * @param movieId the identifier of the movie to delete
     * @return a MovieIdResponse with the identifier of the deleted movie
     */
    MovieIdResponse deleteMovie(Long movieId);

}
