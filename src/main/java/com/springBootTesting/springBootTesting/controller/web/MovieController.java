package com.springBootTesting.springBootTesting.controller.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springBootTesting.springBootTesting.helpers.ResponseBase;
import com.springBootTesting.springBootTesting.interfaz.WebInterface;
import com.springBootTesting.springBootTesting.model.Movie;
import com.springBootTesting.springBootTesting.services.MovieService;


@CrossOrigin
@Controller
@RequestMapping("/movies")
public class MovieController extends ResponseBase implements WebInterface{

    private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieServices;

    @Override
    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model) {
        LOG.info("index");

        int page = params.get("page") != null 
            ? (Integer.valueOf(params.get("page").toString()) -1) 
            : 0;

        PageRequest pageRequest = PageRequest.of(page,20);

        Page<Movie> pageMovie =  movieServices.getAll(pageRequest);

        int totalPage = pageMovie.getTotalPages();

        if(totalPage > 0){
            List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        model.addAttribute("movies", pageMovie.getContent());

        return "index.html";
    }

    @GetMapping("/show/{id}")
    public ModelAndView show(@PathVariable("id") int id) {
      
        Optional<Movie> movie = movieServices.findById(id);
       
        ModelAndView mav = new ModelAndView("show");

        mav.addObject("movie", movie);

        return mav;
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id, Movie model) {
        movieServices.deleteMovie(id);
       
        return "redirect:/";
    }

    @Override
    @GetMapping("/update")
    public String update(Movie movie, Model model) {
        LOG.info("update");

        movieServices.editMovie(movie);

        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(Movie movie, Model model) {
        movieServices.saveMovie(movie);

        return "redirect:/";
    }
}
