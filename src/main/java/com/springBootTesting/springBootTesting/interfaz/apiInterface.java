package com.springBootTesting.springBootTesting.interfaz;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springBootTesting.springBootTesting.model.Movie;

import info.movito.themoviedbapi.model.core.MovieResultsPage;

public interface apiInterface {

    public MovieResultsPage createMoviesList();
    public ResponseEntity<List<Movie>> index();
    public ResponseEntity<Boolean>deleteMovie(@PathVariable ("id") int id);
    public ResponseEntity<Movie> updateMovie(@Validated @RequestBody Movie movie);
    public ResponseEntity<Movie> create (@Validated @RequestBody Movie movie);
}
