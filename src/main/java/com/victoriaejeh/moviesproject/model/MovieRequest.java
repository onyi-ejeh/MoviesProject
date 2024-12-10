package com.victoriaejeh.moviesproject.model;

import jakarta.enterprise.inject.Model;

import java.util.UUID;

@Model
public class MovieRequest {

    private String title;
    private String genre;
    private int releaseYear;
    private String shortDescription;
    private String director;

    public MovieRequest() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int year) {
        this.releaseYear = year;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String description) {
        this.shortDescription = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie toMovie() {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setReleaseYear(releaseYear);
        movie.setShortDescription(shortDescription);
        movie.setDirector(director);
        return movie;
    }
}
