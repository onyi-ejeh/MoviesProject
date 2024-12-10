package com.victoriaejeh.moviesproject.resource;

import com.victoriaejeh.moviesproject.model.MovieRequest;
import com.victoriaejeh.moviesproject.service.MoviesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/movies")
public class MoviesResource {

    private final MoviesService moviesService;

    @Inject
    public MoviesResource(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(MovieRequest request) {
        var response = moviesService.createMovie(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    //    Download all movies.
    @GET
    @Produces("application/json")
    public Response getAll() {
        var response = moviesService.getMovies();
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    //    Download a movie.
    //    Update a movie
    //    Delete a movie

}