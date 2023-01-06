package com.springBootTesting.springBootTesting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class propertyConfiuration {
    public static String PROPERTY_KEY;

    public static String PROPERTY_TOPIC;

    @Value("${my.apikey}")
    public void setProperty(final String propertyName) {
        PROPERTY_KEY = propertyName;
    } 

    @Value(value = "${message.topic.name}")
    public void setPropertyTop(final String propertyName) {
        PROPERTY_TOPIC = propertyName;
    } 
}