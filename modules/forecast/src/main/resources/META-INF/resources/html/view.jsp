<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.miguelangeljulvez.forecast.model.Currently" %>
<%@ page import="com.miguelangeljulvez.forecast.model.Datum__" %>
<%@ page import="com.miguelangeljulvez.forecast.util.ConversionsUtil" %>
<%@ page import="java.util.*" %>
<%@ include file="init.jsp" %>

<%
    DarkSky darkSky = (DarkSky)renderRequest.getAttribute("darkSky");
    Map<String, Object> contextObjects = new HashMap<>();
    contextObjects.put("darkSky", darkSky);
    contextObjects.put("conversionsUtil", ConversionsUtil.getConversionsUtil());
    contextObjects.put("weatherPortletInstanceConfiguration", weatherPortletInstanceConfiguration);

    Currently currently = darkSky.getCurrently();
    List<Datum__> dataDaily = darkSky.getDaily().getData();
%>

<liferay-ddm:template-renderer
        className="<%= DarkSky.class.getName() %>"
        contextObjects="<%= contextObjects %>"
        displayStyle="<%= displayStyle %>"
        displayStyleGroupId="<%= displayStyleGroupId %>"
        entries="<%= emptyDarkSkyList %>"
>

    <div class="row">
        <div class="col-xs-5">
            <div class="row">
                <div class="col-xs-12">
                    <h3><%=weatherPortletInstanceConfiguration.location()%></h3>
                    <h4><%=ConversionsUtil.getFullDate(currently.getTime(), locale, timeZone.getID())%></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 text-center lead lead1">
                    <strong>
                        <% if ("celsius".equals(weatherPortletInstanceConfiguration.degreesUnits()))
                            out.write((int)ConversionsUtil.round(ConversionsUtil.fahrenheitToCelsius(currently.getTemperature()),0) + " ºC");
                        else
                            out.write((int)ConversionsUtil.round(currently.getTemperature(),0) + " ºF");
                        %>
                    </strong>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 text-center lead">
                    <strong>
                        <% if ("kilometers".equals(weatherPortletInstanceConfiguration.windUnits()))
                            out.write((int)ConversionsUtil.round(ConversionsUtil.milesToKilometers(currently.getWindSpeed()),0) + " km/h");
                        else
                            out.write((int)ConversionsUtil.round(currently.getWindSpeed(),0) + " mph");
                        %>
                    </strong>
                </div>
            </div>
        </div>
        <div class="col-xs-7 text-right">
            <canvas id="<portlet:namespace/>iconNow" width="180" height="180"></canvas>
        </div>
    </div>

    <hr />

    <%
        for (int i = 0; i < dataDaily.size(); i++) {
            Datum__ datum = dataDaily.get(i);
    %>
    <div class="row">
        <div class="col-md-4 col-xs-3 dayWeek">
            <%= ConversionsUtil.getDayWeekDisplayName(datum.getTime(), locale, timeZone.getID()) %>
        </div>
        <div class="col-md-2 col-xs-2 text-right">
            <canvas id="<portlet:namespace/>iconDay<%=i%>" width="30" height="30"></canvas>
        </div>
        <div class="col-md-3 col-xs-3 text-right">
            <% if ("kilometers".equals(weatherPortletInstanceConfiguration.windUnits()))
                out.write((int)ConversionsUtil.round(ConversionsUtil.milesToKilometers(datum.getWindSpeed()),0) + "km/h");
            else
                out.write((int)ConversionsUtil.round(datum.getWindSpeed(),0) + "mph");
            %>
        </div>
        <div class="col-md-3 col-xs-4 text-right">
            <% if ("celsius".equals(weatherPortletInstanceConfiguration.degreesUnits()))
                out.write((int)ConversionsUtil.round(ConversionsUtil.fahrenheitToCelsius(datum.getTemperatureMin()),0) + "ºC");
            else
                out.write((int)ConversionsUtil.round(datum.getTemperatureMin(),0) + "ºF");
            %>
            /
            <% if ("celsius".equals(weatherPortletInstanceConfiguration.degreesUnits()))
                out.write((int)ConversionsUtil.round(ConversionsUtil.fahrenheitToCelsius(datum.getTemperatureMax()),0) + "ºC");
            else
                out.write((int)ConversionsUtil.round(datum.getTemperatureMax(),0) + "ºF");
            %>
        </div>
    </div>
    <% } %>

</liferay-ddm:template-renderer>

<script>
    var skycons<portlet:namespace/> = new Skycons({"color": "#65B6F0"});
    skycons<portlet:namespace/>.add("<portlet:namespace/>iconNow", Skycons.<%=currently.getIcon().toUpperCase().replaceAll("-","_")%>);
    <%
    for (int i = 0; i < dataDaily.size(); i++) {
        Datum__ datum = dataDaily.get(i);
    %>
    skycons<portlet:namespace/>.add("<portlet:namespace/>iconDay<%=i%>", Skycons.<%=datum.getIcon().toUpperCase().replaceAll("-","_")%>);
    <%	}	%>
    skycons<portlet:namespace/>.play();
</script>

<%!
    private static List<DarkSky> emptyDarkSkyList = new ArrayList<>();
%>