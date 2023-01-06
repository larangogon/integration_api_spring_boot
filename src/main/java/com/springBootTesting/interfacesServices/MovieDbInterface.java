package com.springBootTesting.interfacesServices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public interface MovieDbInterface {

    public MovieDb getMovieInfoDB(@PathVariable("movieId") Integer movieId);

    public MovieResultsPage getPopularMovies();

    public MovieResultsPage getRatingMovie(@PathVariable("movieId") Integer movieId);

    public ResponseEntity<String> handleNoSuchElementFoundException( Throwable exception);
    
}
