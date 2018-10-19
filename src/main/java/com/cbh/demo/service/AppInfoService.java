package com.cbh.demo.service;

import com.cbh.demo.model.AppInfo;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
public interface AppInfoService {

    AppInfo getByAppKey(String appKey);
}
