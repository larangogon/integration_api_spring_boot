package com.springBootTesting.springBootTesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootTesting.springBootTesting.events.producer.KafkaStringProducer;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class KafkaTestController {
	@Autowired
	KafkaStringProducer kafkaMessageProducer;
	
	@PostMapping("/add/{topic}")
	public void addIdCustomer( @PathVariable String topic,@RequestBody  String body)
	{
		kafkaMessageProducer.sendMessage(topic,body);
	}
}
