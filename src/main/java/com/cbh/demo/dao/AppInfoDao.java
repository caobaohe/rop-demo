package com.cbh.demo.dao;

import com.cbh.demo.model.AppInfo;

public interface AppInfoDao {
    int deleteByPrimaryKey(String appKey);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(String appKey);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
}