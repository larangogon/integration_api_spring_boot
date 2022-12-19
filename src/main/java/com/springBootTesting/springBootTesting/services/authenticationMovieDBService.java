package com.springBootTesting.springBootTesting.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.springBootTesting.springBootTesting.helpers.responseBase;
import com.springBootTesting.springBootTesting.interfacesServices.authenticationApi;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbAuthentication;
import info.movito.themoviedbapi.model.config.TokenSession;

public class authenticationMovieDBService extends responseBase implements authenticationApi{

    private static final Logger LOG = LoggerFactory.getLogger(authenticationMovieDBService.class);

    @Value("${my.apikey}")
    private String apiKey;
    
    public TokenSession getGuestSessionToken() {
        LOG.info("getGuestSessionToken...");

        TmdbAuthentication auth = new TmdbApi(apiKey).getAuthentication();

        TokenSession token = auth.getGuestSessionToken();

        return token;
    }
}
