package com.springBootTesting.springBootTesting.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springBootTesting.springBootTesting.helpers.responseBase;
import com.springBootTesting.springBootTesting.interfacesServices.authenticationApi;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbAuthentication;
import info.movito.themoviedbapi.model.config.TokenSession;

@Service
public class authenticationMovieDBService extends responseBase implements authenticationApi{

    private static final Logger LOG = LoggerFactory.getLogger(authenticationMovieDBService.class);

    public TokenSession getGuestSessionToken() {
        LOG.info("getGuestSessionToken...");

        TmdbAuthentication auth = new TmdbApi("cad0d95925c6869c60ed49f550af6c90").getAuthentication();

        TokenSession token = auth.getGuestSessionToken();

        return token;
    }

    public TokenSession getAuthentication() {
        LOG.info("getAuthentication...");

        TmdbAuthentication auth = new TmdbApi("<apikey>").getAuthentication();

        TokenSession token = auth.getGuestSessionToken();

        return token;
    }
}
