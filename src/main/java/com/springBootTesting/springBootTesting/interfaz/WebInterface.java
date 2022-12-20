package com.springBootTesting.springBootTesting.interfaz;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import com.springBootTesting.springBootTesting.model.Movie;


public interface WebInterface {

    public String index(@RequestParam Map<String, Object> params, Model model);
    public String delete(@PathVariable int id, Movie model);
    public String update(Movie movie, Model model);
    public String create(Movie movie, Model model); 
    public ModelAndView show(@PathVariable("id") int id); 
}