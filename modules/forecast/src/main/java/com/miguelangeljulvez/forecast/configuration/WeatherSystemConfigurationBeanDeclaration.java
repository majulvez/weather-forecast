package com.miguelangeljulvez.forecast.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import org.osgi.service.component.annotations.Component;

@Component
public class WeatherSystemConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

    @Override
    public Class<?> getConfigurationBeanClass() {
        return WeatherSystemConfiguration.class;
    }
}
