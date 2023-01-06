package com.springBootTesting.repoisitories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootTesting.model.Movie;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Serializable>{
    List<Movie> findByExternalId(Integer externalId);
}
