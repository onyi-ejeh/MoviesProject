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
        return Response.status(Response.Status.OK).entity(response).build();
    }

    //    Download a movie.
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

    //    Delete a movie.
    @DELETE
    @Path("/{movie_id}")
    @Produces("application/json")
    public Response deleteMovie(@PathParam("movie_id") Long id) {
        var response = moviesService.deleteMovie(id);
        return Response.status(Response.Status.OK).entity(response).build();
    }

    // Update a movie
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