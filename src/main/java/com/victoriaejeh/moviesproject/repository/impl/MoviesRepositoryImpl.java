package com.victoriaejeh.moviesproject.repository.impl;

import com.victoriaejeh.moviesproject.model.Movie;
import com.victoriaejeh.moviesproject.repository.MoviesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Implementation of the MoviesRepository interface.
 * <p>
 * This class provides data access operations for Movie entities using JPA.
 * </p>
 */
@ApplicationScoped
@Transactional
@Model
public class MoviesRepositoryImpl implements MoviesRepository {

    /**
     * The EntityManager used to interact with the persistence context.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Retrieves all movies from the database, ordered by title.
     *
     * @return a list of Movie entities
     */
    @Override
    public List<Movie> findMovies() {
        String sql = "SELECT * FROM movies ORDER BY title";
        Query query = entityManager.createNativeQuery(sql, Movie.class);
        List<Movie> movies = query.getResultList();
        return movies;
    }

    /**
     * Finds a movie by its identifier.
     *
     * @param id the identifier of the movie
     * @return the Movie entity if found, otherwise null
     */
    @Override
    public Movie findMovieById(Long id) {
        return entityManager.find(Movie.class, id);
    }

    /**
     * Updates an existing movie in the database.
     *
     * @param movie the movie entity with updated information
     * @return the identifier of the updated movie
     */
    @Override
    public Long updateMovie(Movie movie) {
        entityManager.merge(movie);
        return movie.getId();
    }

    /**
     * Persists a new movie in the database.
     *
     * @param movie the movie entity to be created
     * @return the identifier of the newly created movie
     */
    @Override
    public Long createMovie(Movie movie) {
        entityManager.persist(movie);
        return movie.getId();
    }

    /**
     * Deletes a movie from the database.
     *
     * @param id the identifier of the movie to be deleted
     * @return the identifier of the deleted movie
     */
    @Override
    public Long deleteMovie(Long id) {
        var movie = findMovieById(id);
        entityManager.remove(movie);
        return movie.getId();
    }
}
