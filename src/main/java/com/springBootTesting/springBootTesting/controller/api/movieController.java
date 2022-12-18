package com.springBootTesting.springBootTesting.controller.api;

import java.util.List;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootTesting.springBootTesting.helpers.responseBase;
import com.springBootTesting.springBootTesting.interfaz.appApi;
import com.springBootTesting.springBootTesting.model.Movie;
import com.springBootTesting.springBootTesting.services.movieService;


@CrossOrigin
@RestController
@RequestMapping("/api/moviesDB")
public class movieController extends responseBase implements appApi{

    private static final Logger LOG = LoggerFactory.getLogger(movieController.class);

    private movieService movieServices;

    @Override
    @GetMapping("/index")
    public ResponseEntity<List<Movie>> index() {
        LOG.info("api/index");

        List<Movie> movies = (List<Movie>) movieServices.getAllMovies();

        return new ResponseEntity<List<Movie>>(movies, null, HttpStatus.SC_ACCEPTED);
    }

    @Override
    @DeleteMapping("/delete")
    public String delete() {
        LOG.info("api/delete");
        return null;
    }

    @PostMapping("/api/create")
    public ResponseEntity<Movie> create (@Validated @RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(movieServices.saveMovie(movie));
    }

    @Override
    @PutMapping("/update")
    public String update() {
        LOG.info("api/update");
        return null;
    }
}
