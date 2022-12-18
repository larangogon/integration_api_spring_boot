package com.springBootTesting.springBootTesting.controller.api;

import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootTesting.springBootTesting.helpers.responseBase;
import com.springBootTesting.springBootTesting.interfaz.apiInterface;
import com.springBootTesting.springBootTesting.model.Movie;
import com.springBootTesting.springBootTesting.services.movieDbService;
import com.springBootTesting.springBootTesting.services.movieService;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;


@CrossOrigin
@RestController
@RequestMapping("/api/moviesDB")
public class movieController extends responseBase implements apiInterface{

    private static final Logger LOG = LoggerFactory.getLogger(movieController.class);

    private movieService movieServices;

    private movieDbService movieServiceDb;

    
    @GetMapping("/create/list")
    public MovieResultsPage createMoviesList() {
        LOG.info("createMoviesList");

        //guardar en d data
        MovieResultsPage data =  movieServiceDb.getPopularMovies();

        return data;
    }

    @GetMapping(value = "/show/{id}")
    public MovieDb gMovieResultsPage(@PathVariable ("id") int id) {
        LOG.info("createMoviesList");

        MovieDb data =  movieServiceDb.getMovieInfoDB(id);

        return data;
    }

    @Override
    @GetMapping("/index")
    public ResponseEntity<List<Movie>> index() {
        LOG.info("api/index");

        List<Movie> movies = (List<Movie>) movieServices.getAllMovies();

        return new ResponseEntity<List<Movie>>(movies, null, HttpStatus.SC_ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable ("id") int id){
        movieServices.deleteMovie(id);
        return ResponseEntity.ok(!movieServices.existById(id));
    }

    @PostMapping("/api/create")
    public ResponseEntity<Movie>create(@Validated @RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(movieServices.saveMovie(movie));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> findById(@PathVariable ("id") int id){

        if (movieServices.findById(id) == null)
        return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(null);
        
        return ResponseEntity.status(HttpStatus.SC_OK).body(movieServices.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Movie> updateMovie(@Validated @RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(movieServices.editMovie(movie));
    }
}
