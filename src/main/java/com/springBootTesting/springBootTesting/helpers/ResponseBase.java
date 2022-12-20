package com.springBootTesting.springBootTesting.helpers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ResponseBase {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseBase.class);

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(
        Throwable exception
    ) {

        UUID uuid = UUID.randomUUID();

        LOG.error("handleNoSuchElementFoundException: " , uuid, exception.getMessage(), exception.getCause());

        return ResponseEntity
        .badRequest()
        .header("request", "ID:" + uuid)
        .body(exception.getMessage());
    }
}
