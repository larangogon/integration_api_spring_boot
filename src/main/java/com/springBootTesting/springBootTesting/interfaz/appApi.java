package com.springBootTesting.springBootTesting.interfaz;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.springBootTesting.springBootTesting.model.Movie;

public interface appApi {

    public ResponseEntity<List<Movie>> index();
    
    public String delete();
    public String update();
    public ResponseEntity<Movie> create (@Validated @RequestBody Movie movie);
}
