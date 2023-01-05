package com.springBootTesting.springBootTesting.events.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.springBootTesting.springBootTesting.interfaz.KafkaProducerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class KafkaStringProducer implements KafkaProducerService{

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducer.class);

    @Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value(value = "${message.topic.name:profesorp}")
	private String topicName;	
	
	public void sendMessage(String topic,String message) {
        if (topic==null || topic.trim().equals(""))
        
        topic=topicName;

        LOGGER.info("Producing message {}", message);
	
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

        future.addCallback((ListenableFutureCallback<? super SendResult<String, String>>) new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.err.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
	    });
	}

}
