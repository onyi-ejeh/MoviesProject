package com.victoriaejeh.moviesproject.repository;

import com.victoriaejeh.moviesproject.model.Movie;

import java.util.List;
import java.util.UUID;

public interface MoviesRepository {

    List<Movie> findMovies();

    Movie findMovieById(Long id);

    Long updateMovie(Movie movie);

    Long createMovie(Movie movie);

    Long deleteMovie(Long id);

}
