package com.victoriaejeh.moviesproject.service.impl;

import com.victoriaejeh.moviesproject.model.*;
import com.victoriaejeh.moviesproject.repository.MoviesRepository;
import com.victoriaejeh.moviesproject.service.MoviesService;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Model
public class MovieServiceImpl implements MoviesService {

    private final MoviesRepository moviesRepository;

    @Inject
    public MovieServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public MovieIdResponse createMovie(MovieRequest movieRequest) {
        Long movieId = moviesRepository.createMovie(movieRequest.toMovie());
        return new MovieIdResponse(movieId);
    }

    @Override
    public MoviesResponse getMovies() {
        List<Movie> list = moviesRepository.findMovies();
        var responseList = list.stream()
                .map(MovieResponse::new)
                .collect(Collectors.toList());
        return new MoviesResponse(responseList);
    }

    @Override
    public MovieResponse getMovie(Long movieId) {
        var movie = moviesRepository.findMovieById(movieId);
        if (movie == null) {
            throw new NotFoundException("Movie not found");
        }
        return new MovieResponse(movie);
    }

    @Override
    public MovieIdResponse updateMovie(Long movieId, MovieRequest movieRequest) {
        var movie = moviesRepository.findMovieById(movieId);
        if (movie == null) {
            throw new NotFoundException("Movie not found");
        }
        movie.merge(movieRequest.toMovie());
        return new MovieIdResponse(moviesRepository.updateMovie(movie));
    }

    @Override
    public MovieIdResponse deleteMovie(Long movieId) {
        return new MovieIdResponse(moviesRepository.deleteMovie(movieId));
    }

}
