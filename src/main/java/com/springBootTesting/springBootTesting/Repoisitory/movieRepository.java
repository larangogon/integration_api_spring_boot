package com.springBootTesting.springBootTesting.Repoisitory;

import org.springframework.data.repository.CrudRepository;

import com.springBootTesting.springBootTesting.model.Movie;

public interface movieRepository extends CrudRepository<Movie, Integer>{
    
}
