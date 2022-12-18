package com.springBootTesting.springBootTesting.interfaz;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springBootTesting.springBootTesting.model.Movie;

public interface appApi {

    public ResponseEntity<List<Movie>> index();
    
    public String delete();
    public String update();
    public String create(); 
}
