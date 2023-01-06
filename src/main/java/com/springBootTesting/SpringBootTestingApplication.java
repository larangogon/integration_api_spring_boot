package com.springBootTesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestingApplication {

	public static void main(String[] args) {
		System.out.println(args);

		SpringApplication.run(SpringBootTestingApplication.class, args);
	}
}
