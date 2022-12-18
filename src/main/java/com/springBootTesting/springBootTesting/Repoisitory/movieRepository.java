package com.springBootTesting.springBootTesting.Repoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootTesting.springBootTesting.model.Movie;

@Repository
public interface movieRepository extends JpaRepository<Movie, Integer>{}
