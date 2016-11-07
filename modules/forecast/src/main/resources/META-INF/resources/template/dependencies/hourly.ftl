<#assign currently = darkSky.getCurrently()>
<#assign hourly = darkSky.getHourly()>


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
<div class="table-responsive">
        <table class="table">
            <thead>
                <tr>
                    <#list hourly.getData() as datum>
                        <#if datum?index == 12>
                            <#break>
                        </#if>
                        <th class="text-center">
                            <#assign hour = conversionsUtil.getHourDisplayName(datum.getTime(), locale, timeZone.getID())>
                            <#if hour?length == 1>0</#if>${hour}
                        </th>
                    </#list>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <#list hourly.getData() as datum>
                        <#if datum?index == 12>
                            <#break>
                        </#if>
                        <td>
                            <canvas id="<@portlet.namespace/>iconHourly${datum?index}" width="20" height="20"></canvas>
                        </td>
                    </#list>
                </tr>
            </tbody>
        </table>
</div>

<script>
    var skycons<@portlet.namespace/> = new Skycons({"color": "pink"});
    skycons<@portlet.namespace/>.add("<@portlet.namespace/>iconNow", Skycons.${currently.getIcon()?upper_case?replace("-","_")});
    <#list hourly.getData() as datum>
        <#if datum?index == 12>
            <#break>
        </#if>
        skycons<@portlet.namespace/>.add("<@portlet.namespace/>iconHourly${datum?index}", Skycons.${datum.getIcon()?upper_case?replace("-","_")});
    </#list>
    skycons<@portlet.namespace/>.play();
</script>