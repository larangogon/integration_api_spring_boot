package com.springBootTesting.springBootTesting.interfacesServices;

import info.movito.themoviedbapi.model.config.TokenSession;

public interface authenticationApi {

    public TokenSession getGuestSessionToken();

    public TokenSession getAuthentication();
}