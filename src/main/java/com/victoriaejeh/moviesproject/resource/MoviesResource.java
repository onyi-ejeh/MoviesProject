package com.victoriaejeh.moviesproject.resource;

import com.victoriaejeh.moviesproject.model.MovieRequest;
import com.victoriaejeh.moviesproject.service.MoviesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

/**
 * REST resource class that exposes endpoints to manage movies.
 * <p>
 * This class provides endpoints for creating, retrieving, updating, and deleting movie records.
 * </p>
 */
@Path("/movies")
public class MoviesResource {

    /**
     * Service layer for handling movie-related operations.
     */
    private final MoviesService moviesService;

    /**
     * Constructs a MoviesResource with the given MoviesService.
     *
     * @param moviesService the service used to manage movies
     */
    @Inject
    public MoviesResource(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    /**
     * Creates a new movie.
     *
     * @param request the movie request containing the details for the new movie
     * @return a Response with status CREATED and the created movie entity
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(MovieRequest request) {
        // Used var to declare a variable without actually knowing what type of variable it is.
        var response = moviesService.createMovie(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    /**
     * Retrieves all movies.
     *
     * @return a Response with status OK and the list of movies
     */
    @GET
    @Produces("application/json")
    public Response getAll() {
        var response = moviesService.getMovies();
        return Response.status(Response.Status.OK).entity(response).build();
    }

    /**
     * Retrieves a movie by its identifier.
     *
     * @param id the identifier of the movie to retrieve
     * @return a Response with status OK and the movie entity if found,
     *         otherwise a Response with status NOT_FOUND
     */
    @GET
    @Path("/{movie_id}")
    @Produces("application/json")
    public Response getMovie(@PathParam("movie_id") Long id) {
        try {
            var response = moviesService.getMovie(id);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Deletes a movie by its identifier.
     *
     * @param id the identifier of the movie to delete
     * @return a Response with status OK and the result of the delete operation
     */
    @DELETE
    @Path("/{movie_id}")
    @Produces("application/json")
    public Response deleteMovie(@PathParam("movie_id") Long id) {
        var response = moviesService.deleteMovie(id);
        return Response.status(Response.Status.OK).entity(response).build();
    }

    /**
     * Updates an existing movie.
     *
     * @param id      the identifier of the movie to update
     * @param request the movie request containing updated movie details
     * @return a Response with status OK and the updated movie entity if successful,
     *         otherwise a Response with status NOT_FOUND if the movie does not exist
     */
    @PUT
    @Path("/{movie_id}")
    @Produces("application/json")
    public Response updateMovie(@PathParam("movie_id") Long id, MovieRequest request) {
        try {
            var response = moviesService.updateMovie(id, request);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
