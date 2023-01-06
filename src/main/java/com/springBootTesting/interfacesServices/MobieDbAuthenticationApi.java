package com.springBootTesting.interfacesServices;

import info.movito.themoviedbapi.model.config.TokenSession;

public interface MobieDbAuthenticationApi {

    public TokenSession getGuestSessionToken();
}