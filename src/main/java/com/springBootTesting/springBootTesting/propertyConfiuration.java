package com.springBootTesting.springBootTesting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class propertyConfiuration {
    public static String PROPERTY_NAME;

    @Value("${my.apikey}")
    public void setProperty(final String propertyName) {
        PROPERTY_NAME = propertyName;
    } 
}