package com.victoriaejeh.moviesproject.model;

/**
 * Represents the response model for a Movie.
 * <p>
 * This class provides a read-only view of the movie details to be sent in responses.
 * It includes information such as the movie's id, title, genre, release year, short description,
 * director, and actors.
 * </p>
 */
public class MovieResponse {

    /**
     * The unique identifier of the movie as a String.
     */
    private final String id;

    /**
     * The title of the movie.
     */
    private final String title;

    /**
     * The genre of the movie.
     */
    private final String genre;

    /**
     * The release year of the movie.
     */
    private final int releaseYear;

    /**
     * A short description of the movie.
     */
    private final String shortDescription;

    /**
     * The director of the movie.
     */
    private final String director;

    /**
     * The actors in the movie.
     */
    private final String actors;

    /**
     * Constructs a MovieResponse based on the given Movie.
     *
     * @param movie the movie entity from which to extract response details
     */
    public MovieResponse(Movie movie) {
        this.id = movie.getId().toString();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.releaseYear = movie.getReleaseYear();
        this.shortDescription = movie.getShortDescription();
        this.director = movie.getDirector();
        this.actors = "";
    }

    /**
     * Returns the movie's unique identifier.
     *
     * @return the movie's id as a String
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the genre of the movie.
     *
     * @return the movie's genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the title of the movie.
     *
     * @return the movie's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the release year of the movie.
     *
     * @return the movie's release year
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Returns the short description of the movie.
     *
     * @return the movie's short description
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Returns the director of the movie.
     *
     * @return the movie's director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Returns the actors of the movie.
     *
     * @return the movie's actors as a String
     */
    public String getActors() {
        return actors;
    }
}
