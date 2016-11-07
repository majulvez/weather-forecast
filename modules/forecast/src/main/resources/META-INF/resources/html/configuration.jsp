<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL"/>

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL"/>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm"
          onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>"/>
    <aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>"/>

    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280">

            <aui:fieldset-group markupView="lexicon">
                <aui:fieldset collapsible="<%= true %>" label="settings">
                    <aui:input name="preferences--darkSkyAPIKey--" type="text" value="<%= darkSkyAPIKey%>"/>
                    <aui:input name="preferences--googleMapsAPIKey--" type="text" value="<%= googleMapsAPIKey%>"/>
                </aui:fieldset>
            </aui:fieldset-group>

            <aui:fieldset-group markupView="lexicon">
                <aui:fieldset collapsible="<%= true %>" label="location-label">
                    <div class="row">
                        <div class="col-md-4 col-xs-12">
                            <aui:input name="preferences--location--" type="text" value="<%= location%>"/>
                            <aui:input name="preferences--geoCoordinates--" type="text" value="<%= geoCoordinates%>" helpMessage="geoCoordinates-help"/>
                            <button type="button" class="btn-default" onclick="<portlet:namespace />getMyLocation();"><liferay-ui:message key="use-my-location" /></button>
                            <i id="<portlet:namespace />status" aria-hidden="true"></i>
                    </div>
                        <div class="col-md-8 col-xs-12">
                            <% if (Validator.isNotNull(googleMapsAPIKey)) { %>
                                <div id="<portlet:namespace/>mapcanvas" style="width: 600px;height: 400px" class="pull-right"></div>
                            <% } else { %>
                                <liferay-ui:message key="warning-google-map" />
                            <% } %>
                        </div>
                    </div>
                </aui:fieldset>
            </aui:fieldset-group>

            <aui:fieldset-group markupView="lexicon">
                <aui:fieldset collapsible="<%= true %>" label="options">
                    <aui:input name="preferences--requestInterval--" type="text" value="<%= requestInterval%>" helpMessage="requestInterval-help">
                        <aui:validator name="digits"></aui:validator>
                        <aui:validator name="min">0</aui:validator>
                    </aui:input>
                    <aui:select name="preferences--degreesUnits--">
                        <aui:option selected='<%= degreesUnits.equals("celsius") %>' value="celsius"><liferay-ui:message key="celsius" /></aui:option>
                        <aui:option selected='<%= degreesUnits.equals("fahrenheit") %>' value="fahrenheit"><liferay-ui:message key="fahrenheit" /></aui:option>
                    </aui:select>
                    <aui:select name="preferences--windUnits--">
                        <aui:option selected='<%= windUnits.equals("kilometers") %>' value="kilometers"><liferay-ui:message key="kilometers" /></aui:option>
                        <aui:option selected='<%= windUnits.equals("miles") %>' value="miles"><liferay-ui:message key="miles" /></aui:option>
                    </aui:select>
                </aui:fieldset>
            </aui:fieldset-group>

            <aui:fieldset-group markupView="lexicon">
            <aui:fieldset collapsible="<%= true %>" label="network-options">
                <aui:input name="preferences--proxyHost--" type="text" value="<%= proxyHost %>"/>
                <aui:input name="preferences--proxyPort--" type="text" value="<%= proxyPort %>"/>
                <aui:input name="preferences--proxyUser--" type="text" value="<%= proxyUser %>"/>
                <aui:input name="preferences--proxyPassword--" type="text" value="<%= proxyPassword %>"/>
            </aui:fieldset>
            </aui:fieldset-group>

            <aui:fieldset-group markupView="lexicon">
                <aui:fieldset collapsible="<%= true %>" label="templates">
                    <div class="display-template">
                        <liferay-ddm:template-selector
                                className="<%= DarkSky.class.getName() %>"
                                displayStyle="<%= displayStyle %>"
                                displayStyleGroupId="<%= displayStyleGroupId %>"
                                refreshURL="<%= configurationRenderURL %>"
                                showEmptyOption="<%= true %>"
                        />
                    </div>
                </aui:fieldset>

            </aui:fieldset-group>

            <div class="row">
                <div class="col-md-3">
                    <a href="https://darksky.net" target="_blank"><img src="https://darksky.net/dev/img/attribution/poweredby.png" height="30px" border="0" /></a>
                </div>
                <div class="col-md-9 text-right">
                    <span class="text-muted">Powered by Miguel Ángel Júlvez (<a href="https://www.miguelangeljulvez.com" target="_blank">https://www.miguelangeljulvez.com</a>)</span>
                </div>
            </div>
        </div>
    </div>

    <aui:button-row>
        <aui:button cssClass="btn-lg" type="submit"/>
    </aui:button-row>
</aui:form>

<aui:script>
    function <portlet:namespace/>saveConfiguration() {
    var Util = Liferay.Util;

    var form = AUI.$(document.<portlet:namespace/>fm);

    submitForm(form);
    }
</aui:script>

<script>
    <% if (Validator.isNotNull(googleMapsAPIKey)) { %>
    var map<portlet:namespace/>;
    var marker<portlet:namespace/>;
    <%
        double latitude = 40.4893538;
        double longitud = -3.6827461;
        if (Validator.isNotNull(geoCoordinates)) {
            try {
                String[] coordinates = geoCoordinates.trim().replaceAll(" ","").split(",");
                latitude = Double.valueOf(coordinates[0]);
                longitud = Double.valueOf(coordinates[1]);
            } catch (Throwable t) {}
        }
    %>
    function <portlet:namespace />initMap() {
        map<portlet:namespace/> = new google.maps.Map(document.getElementById('<portlet:namespace />mapcanvas'), {
            center: {lat: <%=latitude%>, lng: <%=longitud%>},
            zoom: 4
        });

        marker<portlet:namespace/> = new google.maps.Marker({
            position: new google.maps.LatLng(<%=latitude%>, <%=longitud%>),
            map: map<portlet:namespace/>,
            title: ""
        });

        marker<portlet:namespace/>.addListener('click', function(event) {
            new google.maps.InfoWindow({
                position: event.latLng,
                content: event.latLng.lat() + "," + event.latLng.lng()
            }).open(map<portlet:namespace/>, marker<portlet:namespace/>);
        });

        google.maps.event.addListener(map<portlet:namespace/>, "click", function(event) {
            marker<portlet:namespace/>.setPosition(new google.maps.LatLng(event.latLng.lat(), event.latLng.lng()));

            new google.maps.InfoWindow({
                position: event.latLng,
                content: event.latLng.lat() + "," + event.latLng.lng()
            }).open(map<portlet:namespace/>, marker<portlet:namespace/>);
        });
    }
    <% } %>

    function <portlet:namespace />success(position) {
        var s = document.querySelector('#<portlet:namespace />status');

        s.className = 'fa fa-check fa-2x';

        var myLocation = document.querySelector('#<portlet:namespace />geoCoordinates');
        myLocation.value = position.coords.latitude + "," + position.coords.longitude;

        <% if (Validator.isNotNull(googleMapsAPIKey)) { %>
            var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
            var myOptions = {
                zoom: 15,
                center: latlng,
                mapTypeControl: false,
                navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            map<portlet:namespace/>.setOptions(myOptions)

            marker<portlet:namespace/>.setPosition(latlng);

            marker<portlet:namespace/>.addListener('click', function(event) {
                new google.maps.InfoWindow({
                    position: event.latLng,
                    content: event.latLng.lat() + "," + event.latLng.lng()
                }).open(map<portlet:namespace/>, marker<portlet:namespace/>);
            });
        <% } %>
    }

    function <portlet:namespace />error(msg) {
        var s = document.querySelector('#<portlet:namespace />status');
        s.className = 'fa fa-exclamation fa-2x';
    }

    function <portlet:namespace />getMyLocation() {

        var s = document.querySelector('#<portlet:namespace />status');
        s.className = 'fa fa-circle-o-notch fa-spin fa-2x';

        if (location.protocol != 'https:') {
            console.debug("Location won't work in chrome 50+ if you are not using https");
        }

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(<portlet:namespace />success, <portlet:namespace />error);
        } else {
            <portlet:namespace />error('not supported');
        }
    }
</script>

<% if (Validator.isNotNull(googleMapsAPIKey)) { %>
<script type="text/javascript"
        src="//maps.google.com/maps/api/js?key=<%=googleMapsAPIKey%>&amp;callback=<portlet:namespace />initMap"></script>
<% } %>