<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="init.jsp" %>

<article>
    <h3>Requirements</h3>
    Requirements to use this portlet:
    <ul>
        <li>(Required) Getting weather forecast data. Open an account in
            <a href="https://darksky.net" target="_blank">https://darksky.net</a>
            and get a secret key
        </li>
        </li>
        <li>(Optional) Getting coordinates using Google Maps. Open an account in
            <a href="https://maps.google.es" target="_blank">https://maps.google.es</a>
            and get a secret key
        </li>
    </ul>

    <h3>Settings</h3>
    In the portlet settings you can:
    <ul>
        <li>(Required) Set up the coordinates of the area you want to see the weather forecast</li>
        <li>Set up degrees unit and wind unit to use (celsius vs fahrenheit; kph vs mph)</li>
        <li>Set up proxy parameters if you are using one</li>
        <li>Set up time interval between requests to DarkSky API</li>
        <li>Add UI freemarker templates using Liferay ADT</li>
    </ul>

    <div class="alert alert-warning" role="alert">
        DarkSky API is limited up 1000 daily requests (except if you've got a subscription), so the time request interval
        value is important if you are using the same Darksky key in different portlets. Default value is 120 seconds (2 minutes)
        <br />
        Between requests, ehcache object is returned.
    </div>

    <h3>User interface</h3>
    <p>
        This portlet has 2 templates to show a small piece of what you can get. If you want to see all data which is available,
        add a new template and print the variable ${darkSky} in order to see it.
    </p>

    <h3>Data model</h3>
    <p>
        Data model object of ${darkSky} is the equivalent to the json response (See <a
            href="https://darksky.net/dev/docs/response" target="_blank">https://darksky.net/dev/docs/response</a>)
    </p>
</article>