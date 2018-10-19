package com.cbh.demo.rop.manager;

import com.cbh.demo.model.AppInfo;
import com.cbh.demo.service.AppInfoService;
import com.rop.security.AppSecretManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
@Component
public class DemoAppSecretManager implements AppSecretManager {

    @Autowired
    private AppInfoService appInfoService;

    @Override
    public String getSecret(String appKey) {
        AppInfo appInfo = appInfoService.getByAppKey(appKey);
        if (null != appInfo) {
            return appInfo.getAppSecret();
        }
        return null;
    }

    @Override
    public boolean isValidAppKey(String appKey) {
        AppInfo appInfo = appInfoService.getByAppKey(appKey);
        return null != appInfo;
    }
}
