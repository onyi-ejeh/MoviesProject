package com.victoriaejeh.moviesproject.model;


public class MovieResponse {

    private final String id;
    private final String title;
    private final String genre;
    private final int releaseYear;
    private final String shortDescription;
    private final String director;
    private final String actors;

    public MovieResponse(Movie movie) {
        this.id = movie.getId().toString();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.releaseYear = movie.getReleaseYear();
        this.shortDescription = movie.getShortDescription();
        this.director = movie.getDirector();
        this.actors = "";
    }

    public String getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

}
