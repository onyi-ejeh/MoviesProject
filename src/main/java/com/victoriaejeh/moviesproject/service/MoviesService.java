package com.victoriaejeh.moviesproject.service;

import com.victoriaejeh.moviesproject.model.MovieIdResponse;
import com.victoriaejeh.moviesproject.model.MovieRequest;
import com.victoriaejeh.moviesproject.model.MoviesResponse;

public interface MoviesService {

    MovieIdResponse createMovie(MovieRequest movieRequest);

    MoviesResponse getMovies();

    MoviesResponse getMovie();

    MoviesResponse updateMovie();

    MoviesResponse deleteMovie();

}
