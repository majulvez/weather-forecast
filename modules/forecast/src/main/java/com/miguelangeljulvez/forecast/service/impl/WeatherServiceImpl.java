package com.miguelangeljulvez.forecast.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.miguelangeljulvez.forecast.model.DarkSky;
import com.miguelangeljulvez.forecast.service.api.WeatherService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Properties;

@Component(
        immediate = true,
        service = WeatherService.class
)
public class WeatherServiceImpl implements WeatherService {

    @Override
    public DarkSky getData(String portletInstance, String darkSkyAPIKey, long secondsBetweenRequests, double latitud, double longitude, String proxyHost, int proxyPort, String proxyUsername, String proxyPassword) {

        final Instant before = Instant.now();

        PortalCache<String, Serializable> portalCache = (PortalCache<String, Serializable>)multiVMPool.getPortalCache(DarkSky.class.getName());
        DarkSky darkSky = (DarkSky)portalCache.get("data-" + portletInstance);

        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        Date utcDate = Date.from(utc.toInstant());

        if (darkSky != null && (utcDate.getTime()/1000 < (darkSky.getTimestamp() + secondsBetweenRequests))) {
            _log.info("Valid cache. Request time(ms): " + Duration.between(before, Instant.now()).toMillis());
            _log.trace("Returning: " + darkSky);
            return darkSky;
        }

        String url = "https://api.darksky.net/forecast/" + darkSkyAPIKey + "/" + latitud + "," + longitude;
        String jsonInString = callURL(url, proxyHost, proxyPort, proxyUsername, proxyPassword);

        ObjectMapper mapper = new ObjectMapper();
        try {
            darkSky = mapper.readValue(jsonInString, DarkSky.class);
            darkSky.setTimestamp((int) (utcDate.getTime() / 1000));
            portalCache.put("data-" + portletInstance, darkSky);
            _log.debug("Añadido el objeto en la cache");
        } catch (IOException e) {
            darkSky = new DarkSky();
            darkSky.setTimestamp((int) (utcDate.getTime() / 1000));
            _log.error(e.getMessage());
            e.printStackTrace();
        }

        _log.debug("No valid cache. Request time(ms): " + Duration.between(before, Instant.now()).toMillis());
        _log.trace("Returning: " + darkSky);

        return darkSky;
    }

    private String callURL(
            final String urlParam,
            final String proxyHost,
            int proxyPort,
            final String proxyUsername,
            final String proxyPassword) {

        _log.debug("Init request to: " + urlParam);

        Properties systemProperties = System.getProperties();
        if (Validator.isNotNull(proxyHost))
            systemProperties.setProperty("http.proxyHost", proxyHost);
        if (Validator.isNotNull(proxyPort))
            systemProperties.setProperty("http.proxyPort", String.valueOf(proxyPort));
        if (Validator.isNotNull(proxyUsername))
            systemProperties.setProperty("http.proxyUser", proxyUsername);
        if (Validator.isNotNull(proxyPassword))
            systemProperties.setProperty("http.proxyPassword", proxyPassword);

        StringBuilder sb = new StringBuilder();
        URLConnection urlConn;
        InputStreamReader in;
        try {
            URL url = new URL(urlParam);
            urlConn = url.openConnection();
            urlConn.setReadTimeout(60 * 1000);

            in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }

            bufferedReader.close();
            in.close();
        } catch (IOException e) {
            _log.error(e.getMessage());
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Reference
    private MultiVMPool multiVMPool;

    private Log _log = LogFactoryUtil.getLog(WeatherServiceImpl.class.getName());
}
