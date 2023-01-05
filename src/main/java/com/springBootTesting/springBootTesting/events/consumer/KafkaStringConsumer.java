package com.springBootTesting.springBootTesting.events.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);

    @KafkaListener(topics = "${message.topic.name:profesorp}", groupId = "${message.group.name:profegroup}")

    public void listenTopic1(String message) {
        logger.info("Consuming Message {}", message);
        System.out.println("Recieved Message of topic1 in  listener: " + message);
    }
	
	   @KafkaListener(topics = "${message.topic.name2:profesorp-group}", groupId = "${message.group.name:profegroup}")

    public void listenTopic2(String message) {
        logger.info("Consuming Message {}", message);

		System.out.println("Recieved Message of topic2 in  listener "+message);
	}
}

