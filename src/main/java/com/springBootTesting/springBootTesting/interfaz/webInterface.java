package com.springBootTesting.springBootTesting.interfaz;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springBootTesting.springBootTesting.model.Movie;


public interface webInterface {

    public ModelAndView index(
        @RequestParam(required = false, defaultValue = "0") Integer page,
        @RequestParam(required = false, defaultValue = "20") Integer size,
        @RequestParam(required = false, defaultValue = "false") Boolean enablePagination
    );
    
    public String delete(@PathVariable int id, Movie model);
    public String update(Movie movie);
    public String create(Movie movie); 
    public ModelAndView show(@PathVariable("id") int id); 
}