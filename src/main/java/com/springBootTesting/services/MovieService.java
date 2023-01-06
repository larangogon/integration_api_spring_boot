package com.springBootTesting.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springBootTesting.model.Movie;
import com.springBootTesting.repoisitories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Page<Movie>getAll(Pageable pageable){
        Page<Movie> listPage = movieRepository.findAll(pageable);

        return listPage;
    }

    public List<Movie> getAllMovies() {
        List<Movie> list = (List<Movie>) movieRepository.findAll();
        
        return list;
    }

    public Movie saveMovie(Movie movie){
        if(movieRepository.findByExternalId(movie.getExternalId()).isEmpty()){
            return movieRepository.save(movie);
        }

        return movie;
    }

    public void deleteMovie(Integer id){
        movieRepository.deleteById(id);
    }

    public Movie editMovie(Movie movie){
        if (movieRepository.findByExternalId(movie.getExternalId()).isEmpty()
            && movieRepository.existsById(movie.getIdMovie())
        ){
            return movieRepository.save(movie);
        }

            return null;
    }

    public boolean existById(Integer id) {
        return movieRepository.existsById(id);
    }

    public Optional<Movie> findById(Integer id){
        return movieRepository.findById(id);
    }

    public String greet() {
		return "Hello, World";
	}
}
