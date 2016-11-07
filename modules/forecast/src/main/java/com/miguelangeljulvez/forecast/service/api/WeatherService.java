package com.miguelangeljulvez.forecast.service.api;

import com.miguelangeljulvez.forecast.model.DarkSky;

public interface   WeatherService {

    DarkSky getData(
            final String portletInstance,
            final String darkSkyAPIKey,
            long secondsBetweenRequests,
            double latitud,
            double longitude,
            final String proxyHost,
            int proxyPort,
            final String proxyUsername,
            final String proxyPassword
    );
}
