package com.springBootTesting.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.mail")
public class MailSenderConfig {

    @NotNull
    private String host;

    @NotNull
    private int port;

    @NotNull
    private String username;

    @NotNull
    private String password;
}
