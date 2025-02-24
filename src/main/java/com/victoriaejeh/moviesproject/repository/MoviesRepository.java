package com.victoriaejeh.moviesproject.repository;

import com.victoriaejeh.moviesproject.model.Movie;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on Movie entities.
 * <p>
 * This interface defines methods for retrieving, creating, updating, and deleting movies.
 * </p>
 */
public interface MoviesRepository {

    /**
     * Retrieves all movies.
     *
     * @return a list of Movie entities
     */
    List<Movie> findMovies();

    /**
     * Finds a movie by its identifier.
     *
     * @param id the identifier of the movie
     * @return the Movie entity if found, otherwise null
     */
    Movie findMovieById(Long id);

    /**
     * Updates an existing movie.
     *
     * @param movie the Movie entity with updated information
     * @return the identifier of the updated movie
     */
    Long updateMovie(Movie movie);

    /**
     * Persists a new movie.
     *
     * @param movie the Movie entity to be created
     * @return the identifier of the newly created movie
     */
    Long createMovie(Movie movie);

    /**
     * Deletes a movie by its identifier.
     *
     * @param id the identifier of the movie to delete
     * @return the identifier of the deleted movie
     */
    Long deleteMovie(Long id);

}
