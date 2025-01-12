package com.victoriaejeh.moviesproject.repository.impl;

import com.victoriaejeh.moviesproject.model.Movie;
import com.victoriaejeh.moviesproject.repository.MoviesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
@Model
public class MoviesRepositoryImpl implements MoviesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Movie> findMovies() {
        String sql = "SELECT * FROM movies ORDER BY title";
        Query query = entityManager.createNativeQuery(sql, Movie.class);
        List<Movie> movies = query.getResultList();
        return movies;
    }

    @Override
    public Movie findMovieById(Long id) {
        return entityManager.find(Movie.class, id);
    }

    @Override
    public Long updateMovie(Movie movie) {
        entityManager.merge(movie);
        return movie.getId();
    }

    @Override
    public Long createMovie(Movie movie) {
        entityManager.persist(movie);
        return movie.getId();
    }

    @Override
    public Long deleteMovie(Long id) {
        var movie = findMovieById(id);
        entityManager.remove(movie);
        return movie.getId();
    }

}
