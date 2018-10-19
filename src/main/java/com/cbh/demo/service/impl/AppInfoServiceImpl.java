package com.cbh.demo.service.impl;

import com.cbh.demo.dao.AppInfoDao;
import com.cbh.demo.model.AppInfo;
import com.cbh.demo.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoDao appInfoDao;

    @Override
    public AppInfo getByAppKey(String appKey) {
        return appInfoDao.selectByPrimaryKey(appKey);
    }
}
