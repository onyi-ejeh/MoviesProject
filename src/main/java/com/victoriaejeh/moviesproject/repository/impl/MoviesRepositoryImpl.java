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

@ApplicationScoped
@Transactional
@Model
public class MoviesRepositoryImpl implements MoviesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Movie> findMovies() {
        String sql = "SELECT * FROM movies ORDER BY title";
        Query query = entityManager.createNativeQuery(sql);

        List<Movie> movieList = query.getResultList();
        return movieList;
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
    public Long deleteMovie(Movie movie) {
        entityManager.remove(movie);
        return movie.getId();
    }
}
