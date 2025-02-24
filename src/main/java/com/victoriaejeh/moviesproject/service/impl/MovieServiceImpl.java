package com.victoriaejeh.moviesproject.service.impl;

import com.victoriaejeh.moviesproject.model.*;
import com.victoriaejeh.moviesproject.repository.MoviesRepository;
import com.victoriaejeh.moviesproject.service.MoviesService;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the MoviesService interface.
 * <p>
 * This class provides the business logic for managing movies including creation,
 * retrieval, updating, and deletion. It interacts with the MoviesRepository to perform
 * database operations.
 * </p>
 */
@Model
public class MovieServiceImpl implements MoviesService {

    /**
     * Repository for accessing movie data.
     */
    private final MoviesRepository moviesRepository;

    /**
     * Constructs a MovieServiceImpl with the specified MoviesRepository.
     *
     * @param moviesRepository the repository used for movie data access
     */
    @Inject
    public MovieServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    /**
     * Creates a new movie.
     *
     * @param movieRequest the request containing movie details
     * @return a MovieIdResponse containing the identifier of the created movie
     */
    @Override
    public MovieIdResponse createMovie(MovieRequest movieRequest) {
        Long movieId = moviesRepository.createMovie(movieRequest.toMovie());
        return new MovieIdResponse(movieId);
    }

    /**
     * Retrieves all movies.
     *
     * @return a MoviesResponse containing a list of movie responses
     */
    @Override
    public MoviesResponse getMovies() {
        List<Movie> list = moviesRepository.findMovies();
        var responseList = list.stream()
                .map(MovieResponse::new)
                .collect(Collectors.toList());
        return new MoviesResponse(responseList);
    }

    /**
     * Retrieves a movie by its identifier.
     *
     * @param movieId the identifier of the movie to retrieve
     * @return a MovieResponse containing the movie details
     * @throws NotFoundException if the movie is not found
     */
    @Override
    public MovieResponse getMovie(Long movieId) {
        var movie = moviesRepository.findMovieById(movieId);
        if (movie == null) {
            throw new NotFoundException("Movie not found");
        }
        return new MovieResponse(movie);
    }

    /**
     * Updates an existing movie.
     *
     * @param movieId      the identifier of the movie to update
     * @param movieRequest the request containing updated movie details
     * @return a MovieIdResponse containing the identifier of the updated movie
     * @throws NotFoundException if the movie is not found
     */
    @Override
    public MovieIdResponse updateMovie(Long movieId, MovieRequest movieRequest) {
        var movie = moviesRepository.findMovieById(movieId);
        if (movie == null) {
            throw new NotFoundException("Movie not found");
        }
        movie.merge(movieRequest.toMovie());
        return new MovieIdResponse(moviesRepository.updateMovie(movie));
    }

    /**
     * Deletes a movie by its identifier.
     *
     * @param movieId the identifier of the movie to delete
     * @return a MovieIdResponse containing the identifier of the deleted movie
     */
    @Override
    public MovieIdResponse deleteMovie(Long movieId) {
        return new MovieIdResponse(moviesRepository.deleteMovie(movieId));
    }
}
