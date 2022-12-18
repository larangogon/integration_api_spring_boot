package com.springBootTesting.springBootTesting.Repoisitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootTesting.springBootTesting.model.Movie;

public interface movieRepository extends JpaRepository<Movie, Integer>{}
