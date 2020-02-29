package com.miguelangeljulvez.forecast.portlet;

import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.petra.string.StringPool;
import com.miguelangeljulvez.forecast.configuration.WeatherPortletInstanceConfiguration;
import com.miguelangeljulvez.forecast.model.DarkSky;
import com.miguelangeljulvez.forecast.util.ConversionsUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component(
	immediate = true,
	property = {"javax.portlet.name=" + WeatherPortletKeys.WEATHER},
	service = TemplateHandler.class
)
public class WeatherPortletDisplayTemplateHandler extends BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		return DarkSky.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		String portletTitle = PortalUtil.getPortletTitle(WeatherPortletKeys.WEATHER, locale);

		return portletTitle.concat(StringPool.SPACE).concat(LanguageUtil.get(locale, "template"));
	}

	@Override
	public String getResourceName() {
		return WeatherPortletKeys.WEATHER;
	}

	@Override
	protected String getTemplatesConfigPath() {
		return "META-INF/resources/template/dependencies/portlet-display-templates.xml";
	}

	@Override
	public Map<String, Object> getCustomContextObjects() {
		Map<String, Object> objectMap = new HashMap<>();

		objectMap.put("conversionsUtil", ConversionsUtil.getConversionsUtil());
		objectMap.put("weatherPortletInstanceConfiguration", _weatherPortletInstanceConfiguration);

		return objectMap;
	}

	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
			long classPK, String language, Locale locale)
		throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups =	super.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup templateVariableGroupFields = templateVariableGroups.get("fields");
		templateVariableGroupFields.empty();
		templateVariableGroupFields.addVariable("DarkSky data", DarkSky.class, "darkSky");

		TemplateVariableGroup templateVariableGroupVariable = templateVariableGroups.get("general-variables");
		templateVariableGroupVariable.addVariable("Weather Configuration", WeatherPortletInstanceConfiguration.class, "weatherPortletInstanceConfiguration");

		TemplateVariableGroup templateVariableGroupUtil = templateVariableGroups.get("util");
		templateVariableGroupUtil.addVariable("ConversionsUtil", ConversionsUtil.class, "conversionsUtil");


		String[] restrictedVariables = getRestrictedVariables(language);

		TemplateVariableGroup weatherServicesTemplateVariableGroup = new TemplateVariableGroup("darkSky-services", restrictedVariables);
		weatherServicesTemplateVariableGroup.setAutocompleteEnabled(true);

		templateVariableGroups.put(
			weatherServicesTemplateVariableGroup.getLabel(),
			weatherServicesTemplateVariableGroup);

		return templateVariableGroups;
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_weatherPortletInstanceConfiguration = Configurable.createConfigurable(
				WeatherPortletInstanceConfiguration.class, properties);
	}

	private volatile WeatherPortletInstanceConfiguration _weatherPortletInstanceConfiguration;
}