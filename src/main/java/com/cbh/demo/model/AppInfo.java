package com.cbh.demo.model;

import java.io.Serializable;

public class AppInfo implements Serializable {
    private String appKey;

    private String appSecret;

    private static final long serialVersionUID = 1L;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }
}