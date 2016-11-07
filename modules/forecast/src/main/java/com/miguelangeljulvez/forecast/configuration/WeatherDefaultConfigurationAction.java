package com.miguelangeljulvez.forecast.configuration;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.miguelangeljulvez.forecast.portlet.WeatherPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;


@Component(
        configurationPid = "com.miguelangeljulvez.forecast.configuration.WeatherPortletInstanceConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "javax.portlet.name=" + WeatherPortletKeys.WEATHER
        },
        service = ConfigurationAction.class
)
public class WeatherDefaultConfigurationAction extends DefaultConfigurationAction {}