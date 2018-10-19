package com.cbh.demo.rop;

import com.rop.security.ServiceAccessController;
import com.rop.session.Session;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
public class DemoServiceAccessController implements ServiceAccessController {

    @Override
    public boolean isAppGranted(String appKey, String method, String version) {
        // 是否授权应用访问某个服务
        return true;
    }

    @Override
    public boolean isUserGranted(Session session, String method, String version) {
        // 是否授权用户访问某个服务
        return true;
    }
}
