package com.springBootTesting.springBootTesting.controller.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootTesting.springBootTesting.helpers.responseBase;
import com.springBootTesting.springBootTesting.interfaz.movieDbInterface;
import com.springBootTesting.springBootTesting.services.movieDbService;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;


@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class movieDbController extends responseBase implements movieDbInterface{

    private static final Logger LOG = LoggerFactory.getLogger(movieController.class);

    protected movieDbService movieServiceDb = new movieDbService();

    @GetMapping("/list")
    public List<MovieDb> moviesList() {
        LOG.info("moviesList");

        MovieResultsPage data =  movieServiceDb.getPopularMovies();

        return data.getResults();
    }


    @GetMapping(value = "/show/{id}")
    public MovieDb gMovieResultsPage(@PathVariable ("id") Integer id) {
        LOG.info("createMoviesList");

        MovieDb data =  movieServiceDb.getMovieInfoDB(id);

        return data;
    }
}

