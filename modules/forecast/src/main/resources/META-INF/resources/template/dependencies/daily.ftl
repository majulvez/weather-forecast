<#assign currently = darkSky.getCurrently()>
<#assign daily = darkSky.getDaily()>


<div class="row">
    <div class="col-xs-5">
        <div class="row">
            <div class="col-xs-12">
                <h3>${weatherPortletInstanceConfiguration.location()}</h3>
                <h4>${conversionsUtil.getFullDate(currently.getTime(), locale, timeZone.getID())}</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 text-center lead lead1">
            <strong>
            <#if weatherPortletInstanceConfiguration.degreesUnits() == "celsius">
                ${conversionsUtil.round(conversionsUtil.fahrenheitToCelsius(currently.getTemperature()),0)} ºC
            <#else>
                ${conversionsUtil.round(currently.getTemperature(),0)} ºF
            </#if>
            </strong>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 text-center lead">
                <strong>
                <#if weatherPortletInstanceConfiguration.windUnits() == "kilometers">
                    ${conversionsUtil.round(conversionsUtil.milesToKilometers(currently.getWindSpeed()),0)} km/h
                <#else>
                    ${conversionsUtil.round(currently.getWindSpeed(),0)} mph
                </#if>
                </strong>
            </div>
        </div>
    </div>
    <div class="col-xs-7 text-right">
        <canvas id="<@portlet.namespace/>iconNow" width="180" height="180"></canvas>
    </div>
</div>

<hr />

<#list daily.getData() as datum>
<div class="row">
    <div class="col-md-4 col-xs-3 dayWeek">
        ${conversionsUtil.getDayWeekDisplayName(datum.getTime(), locale, timeZone.getID())}
    </div>
    <div class="col-md-2 col-xs-2 text-right">
        <canvas id="<@portlet.namespace/>iconDay${datum?index}" width="30" height="30"></canvas>
    </div>
    <div class="col-md-3 col-xs-3 text-right">
        <#if weatherPortletInstanceConfiguration.windUnits() == "kilometers">
            ${conversionsUtil.round(conversionsUtil.milesToKilometers(datum.getWindSpeed()),0)} km/h
        <#else>
            ${conversionsUtil.round(datum.getWindSpeed(),0)} mph
        </#if>
    </div>
    <div class="col-md-3 col-xs-4 text-right">
        <#if weatherPortletInstanceConfiguration.degreesUnits() == "celsius">
            ${conversionsUtil.round(conversionsUtil.fahrenheitToCelsius(datum.getTemperatureMin()),0)}ºC
        <#else>
            ${conversionsUtil.round(datum.getTemperatureMin(),0)}ºF
        </#if>
        /
        <#if weatherPortletInstanceConfiguration.degreesUnits() == "celsius">
            ${conversionsUtil.round(conversionsUtil.fahrenheitToCelsius(datum.getTemperatureMax()),0)}ºC
        <#else>
            ${conversionsUtil.round(datum.getTemperatureMax(),0)}ºF
        </#if>
    </div>
</div>
</#list>

<script>
    var skycons<@portlet.namespace/> = new Skycons({"color": "pink"});
    skycons<@portlet.namespace/>.add("<@portlet.namespace/>iconNow", Skycons.${currently.getIcon()?upper_case?replace("-","_")});
    <#list daily.getData() as datum>
    skycons<@portlet.namespace/>.add("<@portlet.namespace/>iconDay${datum?index}", Skycons.${datum.getIcon()?upper_case?replace("-","_")});
    </#list>
    skycons<@portlet.namespace/>.play();
</script>