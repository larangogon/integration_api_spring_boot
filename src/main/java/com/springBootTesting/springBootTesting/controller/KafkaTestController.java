package com.springBootTesting.springBootTesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootTesting.springBootTesting.events.producer.KafkaStringProducer;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class KafkaTestController {
	@Autowired
	KafkaStringProducer kafkaMessageProducer;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaTestController.class);
	
	@PostMapping("/add/{topic}")
	public void addIdCustomer(@RequestBody String body)
	{
        LOGGER.info(body);

		kafkaMessageProducer.sendMessage(body);
	}
}
