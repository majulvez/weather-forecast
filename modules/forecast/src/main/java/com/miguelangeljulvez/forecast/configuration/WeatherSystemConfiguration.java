package com.miguelangeljulvez.forecast.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
        category = "web-experience",
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
        factory = true,
        id = "com.miguelangeljulvez.forecast.configuration.WeatherSystemConfiguration",
        localization = "content/Language"
)
public interface WeatherSystemConfiguration {

    @Meta.AD(required = false)
    public String proxyHost();

    @Meta.AD(required = false)
    public String proxyPort();

    @Meta.AD(required = false)
    public String proxyUser();

    @Meta.AD(required = false)
    public String proxyPassword();

    @Meta.AD(deflt = "https://api.darksky.net/forecast/", required = false)
    public String darkSkyURL();
}
