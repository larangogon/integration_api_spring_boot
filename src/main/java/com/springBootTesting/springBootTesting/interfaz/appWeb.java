package com.springBootTesting.springBootTesting.interfaz;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public interface appWeb {

    public ModelAndView index(
        @RequestParam(required = false, defaultValue = "0") Integer page,
        @RequestParam(required = false, defaultValue = "20") Integer size,
        @RequestParam(required = false, defaultValue = "false") Boolean enablePagination
    );
    
    public ModelAndView delete(Integer movieId);
    public ModelAndView update();
    public ModelAndView create(); 
    public ModelAndView show(Integer movieId); 
}