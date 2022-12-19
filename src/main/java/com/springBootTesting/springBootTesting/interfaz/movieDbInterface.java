package com.springBootTesting.springBootTesting.interfaz;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import info.movito.themoviedbapi.model.MovieDb;

public interface movieDbInterface {
    public List<MovieDb> moviesList();
    public MovieDb gMovieResultsPage(@PathVariable ("id") Integer id);
}
