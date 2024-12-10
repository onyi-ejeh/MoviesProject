package com.victoriaejeh.moviesproject.service.impl;

import com.victoriaejeh.moviesproject.model.*;
import com.victoriaejeh.moviesproject.repository.MoviesRepository;
import com.victoriaejeh.moviesproject.service.MoviesService;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

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
        var list = moviesRepository.findMovies();
        var responseListt = new ArrayList<MovieResponse>();
        for (Movie movie : list) {
            responseListt.add(new MovieResponse(movie));
        };
//        var responseList = list.stream()
//                .map(MovieResponse::new)
//                .collect(Collectors.toList());
        return new MoviesResponse(responseListt);
    }

    @Override
    public MoviesResponse getMovie() {
        return null;
    }

    @Override
    public MoviesResponse updateMovie() {
        return null;
    }

    @Override
    public MoviesResponse deleteMovie() {
        return null;
    }

}
