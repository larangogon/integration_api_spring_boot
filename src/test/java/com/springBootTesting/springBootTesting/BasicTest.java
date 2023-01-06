package com.springBootTesting.springBootTesting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springBootTesting.controller.web.MovieController;


@SpringBootTest
public class BasicTest {

    @Autowired
	private MovieController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}