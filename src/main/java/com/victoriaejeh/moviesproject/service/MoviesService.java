package com.victoriaejeh.moviesproject.service;

import com.victoriaejeh.moviesproject.model.MovieIdResponse;
import com.victoriaejeh.moviesproject.model.MovieRequest;
import com.victoriaejeh.moviesproject.model.MovieResponse;
import com.victoriaejeh.moviesproject.model.MoviesResponse;

public interface MoviesService {

    MovieIdResponse createMovie(MovieRequest movieRequest);

    MoviesResponse getMovies();

    MovieResponse getMovie(Long movieId);

    MovieIdResponse updateMovie(Long movieId, MovieRequest movieRequest);

    MovieIdResponse deleteMovie(Long movieId);

}
