package com.miguelangeljulvez.forecast.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
        category = "web-experience",
        scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
        factory = true,
        id = "com.miguelangeljulvez.forecast.configuration.WeatherPortletInstanceConfiguration",
        localization = "content/Language"
)
public interface WeatherPortletInstanceConfiguration {

    @Meta.AD(required = false)
    public String darkSkyAPIKey();

    @Meta.AD(required = false)
    public String googleMapsAPIKey();

    @Meta.AD(required = false)
    public String location();

    @Meta.AD(required = false)
    public String geoCoordinates();

    @Meta.AD(deflt = "120", required = false)
    public long requestInterval();

    @Meta.AD(deflt = "celsius", required = false)
    public String degreesUnits();

    @Meta.AD(deflt = "kilometers", required = false)
    public String windUnits();

    @Meta.AD(required = false)
    public String displayStyle();

    @Meta.AD(required = false)
    public String displayStyleGroupId();

    @Meta.AD(required = false)
    public String proxyHost();

    @Meta.AD(required = false)
    public String proxyPort();

    @Meta.AD(required = false)
    public String proxyUser();

    @Meta.AD(required = false)
    public String proxyPassword();
}
