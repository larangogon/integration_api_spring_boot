package com.springBootTesting.springBootTesting.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springBootTesting.springBootTesting.Repoisitory.movieRepository;
import com.springBootTesting.springBootTesting.model.Movie;

@Service
public class movieService {

    private movieRepository genreRepository;


    public List<Movie> getAllMovies() {
        List<Movie> list = (List<Movie>) genreRepository.findAll();
        
        return list;
    }
    
}
