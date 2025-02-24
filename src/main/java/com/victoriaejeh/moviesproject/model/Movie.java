package com.victoriaejeh.moviesproject.model;

import jakarta.persistence.*;

/**
 * Represents a Movie entity for the movies project.
 * <p>
 * This entity maps to the "movies" table in the database and holds
 * information about a movie, including title, genre, release year,
 * short description, and director.
 * </p>
 */
@Entity
@Table(name = "movies")
public class Movie {

    /**
     * The unique identifier for a movie.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The title of the movie.
     */
    private String title;

    /**
     * The genre of the movie.
     */
    private String genre;

    /**
     * The release year of the movie.
     */
    private int releaseYear;

    /**
     * A short description of the movie.
     */
    private String shortDescription;

    /**
     * The director of the movie.
     */
    private String director;

    /**
     * Default constructor.
     */
    public Movie() {}

    /**
     * Constructs a Movie with the specified details.
     *
     * @param id               the unique identifier of the movie
     * @param title            the title of the movie
     * @param genre            the genre of the movie
     * @param releaseYear      the release year of the movie
     * @param shortDescription a short description of the movie
     * @param director         the director of the movie
     */
    public Movie(Long id, String title, String genre, int releaseYear, String shortDescription, String director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.shortDescription = shortDescription;
        this.director = director;
    }

    /**
     * Returns the genre of the movie.
     *
     * @return the genre of the movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the movie.
     *
     * @param genre the new genre of the movie
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns the title of the movie.
     *
     * @return the title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the movie.
     *
     * @param title the new title of the movie
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the release year of the movie.
     *
     * @return the release year of the movie
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Sets the release year of the movie.
     *
     * @param releaseYear the new release year of the movie
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Returns the short description of the movie.
     *
     * @return the short description of the movie
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the short description of the movie.
     *
     * @param shortDescription the new short description of the movie
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Returns the director of the movie.
     *
     * @return the director of the movie
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the director of the movie.
     *
     * @param director the new director of the movie
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Returns the unique identifier of the movie.
     *
     * @return the unique identifier of the movie
     */
    public Long getId() {
        return id;
    }

    /**
     * Merges the details from another movie into this movie.
     * <p>
     * This method updates the title, genre, release year, short description,
     * and director of the current movie with the corresponding values from
     * the given movie.
     * </p>
     *
     * @param movie the movie whose details are to be merged into this movie
     */
    public void merge(Movie movie) {
        this.title = movie.title;
        this.genre = movie.genre;
        this.releaseYear = movie.releaseYear;
        this.shortDescription = movie.shortDescription;
        this.director = movie.director;
    }

}
