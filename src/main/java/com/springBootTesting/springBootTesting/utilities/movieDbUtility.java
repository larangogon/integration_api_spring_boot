package com.springBootTesting.springBootTesting.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;

import com.springBootTesting.springBootTesting.propertyConfiuration;
import com.springBootTesting.springBootTesting.helpers.ResponseBase;
import com.springBootTesting.springBootTesting.interfacesServices.MovieDbInterface;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public class movieDbUtility extends ResponseBase implements MovieDbInterface{

    private static final Logger LOG = LoggerFactory.getLogger(movieDbUtility.class);

    public MovieDb getMovieInfoDB(@PathVariable("movieId") Integer movieId) {
        LOG.info("Detail of the movie in api bd...");

        TmdbMovies movies = new TmdbApi(propertyConfiuration.PROPERTY_NAME).getMovies();

        MovieDb movie = movies.getMovie(movieId, "en"); 

        return movie;
    }

    public MovieResultsPage getPopularMovies() {
        LOG.info("getPopularMovies...");

        TmdbMovies movies = new TmdbApi(propertyConfiuration.PROPERTY_NAME).getMovies();

        MovieResultsPage moviesPMovieResultsPage = movies.getPopularMovies(null, null);

        return moviesPMovieResultsPage;
    }

    public MovieResultsPage getRatingMovie(@PathVariable("movieId") Integer movieId) {
        LOG.info("ratingMovie");

        TmdbMovies movies = new TmdbApi(propertyConfiuration.PROPERTY_NAME).getMovies();

        MovieResultsPage movie = movies.getTopRatedMovies("en", movieId);

        return movie;
    }
}
