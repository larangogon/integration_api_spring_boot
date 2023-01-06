package com.springBootTesting.springBootTesting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class propertyConfiuration {
    public static String PROPERTY_KEY;

    public static String PROPERTY_TOPIC;

    public static String PROPERTY_LOGO;

    @Value("${my.apikey}")
    public void setProperty(final String propertyName) {
        PROPERTY_KEY = propertyName;
    } 

    @Value(value = "${message.topic.name}")
    public void setPropertyTopic(final String propertyTopic) {
        PROPERTY_TOPIC = propertyTopic;
    } 

    @Value(value = "${mail.logo.admin}")
    public void setPropertyLogo(final String propertyLogo) {
        PROPERTY_LOGO = propertyLogo;
    } 
}