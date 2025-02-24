package com.victoriaejeh.moviesproject.model;

/**
 * Represents a request object for creating or updating a movie.
 * This class acts as a Data Transfer Object (DTO).
 */
public class MovieRequest {

    private String title;
    private String genre;
    private int releaseYear;
    private String shortDescription;
    private String director;

    /**
     * Default constructor.
     */
    public MovieRequest() {}

    /**
     * Gets the title of the movie.
     * @return the movie title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the movie.
     * @param title the movie title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the genre of the movie.
     * @return the movie genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the movie.
     * @param genre the movie genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the release year of the movie.
     * @return the release year
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Sets the release year of the movie.
     * @param releaseYear the year the movie was released
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Gets the short description of the movie.
     * @return the movie description
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the short description of the movie.
     * @param shortDescription a brief description of the movie
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Gets the director of the movie.
     * @return the movie director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the director of the movie.
     * @param director the name of the movie director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Converts this request object into a {@link Movie} entity.
     * @return a new {@code Movie} object populated with request data
     */
    public Movie toMovie() {
        Movie movie = new Movie();
        movie.setTitle(this.title);
        movie.setGenre(this.genre);
        movie.setReleaseYear(this.releaseYear);
        movie.setShortDescription(this.shortDescription);
        movie.setDirector(this.director);
        return movie;
    }
}
