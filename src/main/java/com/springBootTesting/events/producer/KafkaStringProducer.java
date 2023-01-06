package com.springBootTesting.events.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.springBootTesting.config.propertyConfiuration;
import com.springBootTesting.interfaz.KafkaProducerService;

@Component
public class KafkaStringProducer implements KafkaProducerService{

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducer.class);

    @Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message)
    {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(propertyConfiuration.PROPERTY_TOPIC, message);
        
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOGGER.debug("Message {} has been sent ", message);
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("Something went wrong with the message {} ", message);
            }
        });
    }

}
