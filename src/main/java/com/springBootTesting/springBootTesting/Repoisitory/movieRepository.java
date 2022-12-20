package com.springBootTesting.springBootTesting.Repoisitory;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootTesting.springBootTesting.model.Movie;

@Repository("movieRepository")
public interface movieRepository extends JpaRepository<Movie, Serializable>{
    List<Movie> findByExternalId(Integer externalId);
}
