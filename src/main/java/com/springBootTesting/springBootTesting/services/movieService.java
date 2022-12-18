package com.springBootTesting.springBootTesting.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootTesting.springBootTesting.Repoisitory.movieRepository;
import com.springBootTesting.springBootTesting.model.Movie;

@Service
public class movieService {

    @Autowired
    private movieRepository genreRepository;

    public List<Movie> getAllMovies() {
        List<Movie> list = (List<Movie>) genreRepository.findAll();
        
        return list;
    }

    public Movie saveMovie(Movie movie){
        return genreRepository.save(movie);
    }

    public void deleteMovie(Integer id){
        genreRepository.deleteById(id);
    }

    public Movie editMovie(Movie movie){
        if (movie.getTitle() != null && genreRepository.existsById(movie.getIdMovie())){
            return genreRepository.save(movie);
        }
        return null;
    }

    public boolean existById(Integer id) {
        return genreRepository.existsById(id);
    }

    public Optional<Movie> findById(Integer id){
        return genreRepository.findById(id);
    }
    
}
