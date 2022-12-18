package com.springBootTesting.springBootTesting.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;

import com.springBootTesting.springBootTesting.helpers.responseBase;
import com.springBootTesting.springBootTesting.interfacesServices.movieDbInterface;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public class movieDbService extends responseBase implements movieDbInterface{

    private static final Logger LOG = LoggerFactory.getLogger(movieDbService.class);

    public MovieDb getMovieInfoDB(@PathVariable("movieId") Integer movieId) {

        LOG.info("Detail of the movie in api bd...");

        TmdbMovies movies = new TmdbApi("cad0d95925c6869c60ed49f550af6c90").getMovies();

        MovieDb movie = movies.getMovie(movieId, "en"); 

        return movie;
    
    }

    public MovieResultsPage getPopularMovies() {
        LOG.info("getPopularMovies...");

        TmdbMovies movies = new TmdbApi("cad0d95925c6869c60ed49f550af6c90").getMovies();

        MovieResultsPage moviesPMovieResultsPage = movies.getPopularMovies(null, null);

        return moviesPMovieResultsPage;
    }

    public MovieResultsPage getRatingMovie(@PathVariable("movieId") Integer movieId) {

        LOG.info("ratingMovie");

        TmdbMovies movies = new TmdbApi("cad0d95925c6869c60ed49f550af6c90").getMovies();

        MovieResultsPage movie = movies.getTopRatedMovies("en", movieId);

        return movie;
    }
}
