package com.springBootTesting.springBootTesting.interfaz;

public interface KafkaProducerService {
    public void sendMessage(String topic,String message);
}
