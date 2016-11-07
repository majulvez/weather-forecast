package com.miguelangeljulvez.forecast.portlet;

import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.miguelangeljulvez.forecast.configuration.WeatherPortletInstanceConfiguration;
import com.miguelangeljulvez.forecast.configuration.WeatherSystemConfiguration;
import com.miguelangeljulvez.forecast.model.DarkSky;
import com.miguelangeljulvez.forecast.service.api.WeatherService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.Map;

@Component(
	configurationPid =
				"com.miguelangeljulvez.forecast.configuration.WeatherPortletInstanceConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Weather Forecast Portlet",
		"javax.portlet.init-param.config-template=/html/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/view.jsp",
		"javax.portlet.name=" + WeatherPortletKeys.WEATHER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WeatherPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
					   RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		WeatherPortletInstanceConfiguration portletInstanceConfiguration = null;
		try {
			portletInstanceConfiguration = themeDisplay.getPortletDisplay().getPortletInstanceConfiguration(WeatherPortletInstanceConfiguration.class);
		} catch (ConfigurationException e) {
			e.printStackTrace();
			throw new PortletException(e.getMessage());
		}

		String[] coordinates = portletInstanceConfiguration.geoCoordinates().trim().replace(" ", "").split(",");

		DarkSky darkSky = null;
		if (coordinates.length == 2 && Validator.isNotNull(portletInstanceConfiguration.darkSkyAPIKey())) {
			darkSky = _weatherService.getData(
					themeDisplay.getPortletDisplay().getInstanceId(),
					portletInstanceConfiguration.darkSkyAPIKey(),
					portletInstanceConfiguration.requestInterval(),
					GetterUtil.getDouble(coordinates[0]),
					GetterUtil.getDouble(coordinates[1]),
					portletInstanceConfiguration.proxyHost(),
					GetterUtil.getInteger(portletInstanceConfiguration.proxyPort()),
					portletInstanceConfiguration.proxyUser(),
					portletInstanceConfiguration.proxyPassword());
		}

		if (darkSky != null && Validator.isNotNull(portletInstanceConfiguration.darkSkyAPIKey())) {
			renderRequest.setAttribute("darkSky", darkSky);
			include(viewTemplate, renderRequest, renderResponse);
		} else {
			include("/html/configuration-required.jsp", renderRequest, renderResponse);
		}

	}

	public String getDarkSkyAPIKey(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.darkSkyAPIKey());
	}

	public String getGoogleMapsAPIKey(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.googleMapsAPIKey());
	}

	public String getGeoCoordinates(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.geoCoordinates());
	}

	public String getDegreesUnits(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.degreesUnits());
	}

	public String getWindUnits(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.windUnits());
	}

	public String getDisplayStyle(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.displayStyle());
	}

	public String getDisplayStyleGroupId(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.displayStyleGroupId());
	}

	public String getProxyHost(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.proxyHost());
	}

	public String getProxyPort(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.proxyPort());
	}

	public String getProxyUser(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.proxyUser());
	}

	public String getProxyPassword(Map labels) {
		return (String) labels.get(_weatherPortletInstanceConfiguration.proxyPassword());
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_weatherPortletInstanceConfiguration = Configurable.createConfigurable(
				WeatherPortletInstanceConfiguration.class, properties);
	}

	private volatile WeatherPortletInstanceConfiguration _weatherPortletInstanceConfiguration;

	@Reference(unbind = "-")
	protected void setWeatherService(WeatherService weatherService) {
		_weatherService = weatherService;
	}

	private WeatherService _weatherService;


	/*
	Ni idea de cómo funcionar esto. Quiero que la configuracíon del proxy sea a nivel de sistema y el
	resto a nivel del portlet.
	@Reference(unbind = "-")
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		_configurationProvider = configurationProvider;
	}

	private ConfigurationProvider _configurationProvider;
	*/
	private static Log _log = LogFactoryUtil.getLog(WeatherPortlet.class.getName());

}