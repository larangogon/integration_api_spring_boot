package com.springBootTesting.interfaz;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import info.movito.themoviedbapi.model.MovieDb;

public interface MovieDbInterface {
    public List<MovieDb> moviesList();
    public MovieDb gMovieResultsPage(@PathVariable ("id") Integer id);
}
