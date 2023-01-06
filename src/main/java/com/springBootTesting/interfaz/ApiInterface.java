package com.springBootTesting.interfaz;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springBootTesting.model.Movie;

import info.movito.themoviedbapi.model.MovieDb;

public interface ApiInterface {

    public List<MovieDb> createMoviesList();
    public ResponseEntity<List<Movie>> index();
    public ResponseEntity<Boolean> deleteMovie(@PathVariable ("id") Integer id);
    public ResponseEntity<Movie> updateMovie(@Validated @RequestBody Movie movie);
    public ResponseEntity<Movie> create (@Validated @RequestBody Movie movie);
}
