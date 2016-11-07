<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.miguelangeljulvez.forecast.configuration.WeatherPortletInstanceConfiguration" %>
<%@ page import="com.miguelangeljulvez.forecast.model.DarkSky" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    WeatherPortletInstanceConfiguration weatherPortletInstanceConfiguration = portletDisplay.getPortletInstanceConfiguration(WeatherPortletInstanceConfiguration.class);

    String darkSkyAPIKey = StringPool.BLANK;
    String googleMapsAPIKey = StringPool.BLANK;
    String geoCoordinates = StringPool.BLANK;
    String location = StringPool.BLANK;

    long requestInterval = 120;

    String degreesUnits = StringPool.BLANK;
    String windUnits = StringPool.BLANK;

    String displayStyle = StringPool.BLANK;
    long displayStyleGroupId = 0;

    String proxyHost = StringPool.BLANK;
    String proxyPort = StringPool.BLANK;
    String proxyUser = StringPool.BLANK;
    String proxyPassword = StringPool.BLANK;

    if (Validator.isNotNull(weatherPortletInstanceConfiguration)) {

        darkSkyAPIKey = weatherPortletInstanceConfiguration.darkSkyAPIKey();

        googleMapsAPIKey = weatherPortletInstanceConfiguration.googleMapsAPIKey();

        geoCoordinates = weatherPortletInstanceConfiguration.geoCoordinates();

        requestInterval = weatherPortletInstanceConfiguration.requestInterval();

        location = weatherPortletInstanceConfiguration.location();

        degreesUnits = weatherPortletInstanceConfiguration.degreesUnits();

        windUnits = weatherPortletInstanceConfiguration.windUnits();

        displayStyle = weatherPortletInstanceConfiguration.displayStyle();

        displayStyleGroupId = GetterUtil.getLong(weatherPortletInstanceConfiguration.displayStyleGroupId());

        proxyHost = weatherPortletInstanceConfiguration.proxyHost();

        proxyPort = weatherPortletInstanceConfiguration.proxyPort();

        proxyUser = weatherPortletInstanceConfiguration.proxyUser();

        proxyPassword = weatherPortletInstanceConfiguration.proxyPassword();
    }

%>