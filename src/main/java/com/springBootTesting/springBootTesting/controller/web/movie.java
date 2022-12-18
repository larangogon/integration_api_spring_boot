package com.springBootTesting.springBootTesting.controller.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springBootTesting.springBootTesting.helpers.responseBase;
import com.springBootTesting.springBootTesting.interfaz.appWeb;
import com.springBootTesting.springBootTesting.model.Movie;
import com.springBootTesting.springBootTesting.services.movieDb;
import com.springBootTesting.springBootTesting.services.movieService;

import info.movito.themoviedbapi.model.core.MovieResultsPage;

@CrossOrigin
@RestController
@RequestMapping("/moviesDB")
public class movie extends responseBase implements appWeb{

    private static final Logger LOG = LoggerFactory.getLogger(movie.class);

    private movieDb movieServiceDb;

    private movieService movieServices;

    @Override
    @GetMapping("/index")
    public ModelAndView index(Integer page, Integer size, Boolean enablePagination) {
        LOG.info("index");

        MovieResultsPage data =  movieServiceDb.getPopularMovies();

        // guardar toda la data que consultamos en bd

        List<Movie> list = (List<Movie>) movieServices.getAllMovies();
    
        ModelAndView mav = new ModelAndView("index");

        mav.addObject("movies", list);

        return mav;
    }

    @Override
    @GetMapping("/delete/{movieId}")
    public ModelAndView delete(@PathVariable("movieId") Integer movieId) {
        LOG.info("delete");
     
        ModelAndView mav = new ModelAndView("/");

        mav.addObject("movie", "movie");

        return mav;
    }

    @Override
    @GetMapping("/update/{movieId}")
    public ModelAndView update() {
        LOG.info("update");
        ModelAndView mav = new ModelAndView("show");

        mav.addObject("movie", "movie");

        return mav;
    }

    @Override
    @GetMapping("/create")
    public ModelAndView create() {
        LOG.info("create");

        ModelAndView mav = new ModelAndView("show");

        mav.addObject("movie", "movie");

        return mav;
    }

    @Override
    @GetMapping("show/{movieId}")
    public ModelAndView show(@PathVariable("movieId") Integer movieI) {
        LOG.info("show");


        ModelAndView mav = new ModelAndView("show");

        mav.addObject("movie", "movie");

        return mav;
    }
}
