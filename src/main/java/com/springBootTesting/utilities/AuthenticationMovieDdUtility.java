package com.springBootTesting.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springBootTesting.config.propertyConfiuration;
import com.springBootTesting.helpers.ResponseBase;
import com.springBootTesting.interfacesServices.MobieDbAuthenticationApi;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbAuthentication;
import info.movito.themoviedbapi.model.config.TokenSession;

public class AuthenticationMovieDdUtility extends ResponseBase implements MobieDbAuthenticationApi{

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationMovieDdUtility.class);

    public TokenSession getGuestSessionToken() {
        LOG.info("getGuestSessionToken...");

        TmdbAuthentication auth = new TmdbApi(propertyConfiuration.PROPERTY_KEY).getAuthentication();

        TokenSession token = auth.getGuestSessionToken();

        return token;
    }
}
