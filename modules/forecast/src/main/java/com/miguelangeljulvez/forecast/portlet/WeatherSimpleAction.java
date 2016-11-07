package com.miguelangeljulvez.forecast.portlet;


import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.miguelangeljulvez.forecast.model.DarkSky;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.List;

@Component(immediate = true)
public class WeatherSimpleAction extends SimpleAction {

    @Activate
    protected void run() throws ActionException {
        Long companyId = CompanyThreadLocal.getCompanyId();

        try {
            List<Company> companys = _companyLocalService.getCompanies();

            for (Company company : companys) {
                CompanyThreadLocal.setCompanyId(company.getCompanyId());

                run(new String[] {String.valueOf(company.getCompanyId())});
            }
        }
        finally {
            CompanyThreadLocal.setCompanyId(companyId);
        }
    }

    @Override
    public void run(String[] ids) throws ActionException {
        try {
            long companyId = GetterUtil.getLong(ids[0]);

            doRun(companyId);
        }
        catch (Exception e) {
            throw new ActionException(e);
        }
    }

    private void doRun(long companyId) {
        PortalCache<String, Serializable> portalCache = MultiVMPoolUtil.getPortalCache(DarkSky.class.getName());
        portalCache.removeAll();
    }

    @Reference(unbind = "-")
    public void setCompanyLocalService(
            CompanyLocalService companyLocalService) {

        _companyLocalService = companyLocalService;
    }

    private CompanyLocalService _companyLocalService;

    private static Log _log = LogFactoryUtil.getLog(WeatherSimpleAction.class);
}
