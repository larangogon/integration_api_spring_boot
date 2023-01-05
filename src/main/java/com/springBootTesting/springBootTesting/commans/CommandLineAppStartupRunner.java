package com.springBootTesting.springBootTesting.commans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springBootTesting.springBootTesting.events.producer.KafkaStringProducer;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final KafkaStringProducer stringProducer;

    public CommandLineAppStartupRunner(KafkaStringProducer stringProducer) {
        this.stringProducer = stringProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            stringProducer.sendMessage("Hello kafka !! " + i);
            Thread.sleep(2000);
        }
    }
}

