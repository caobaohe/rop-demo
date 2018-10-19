package com.cbh.demo.request;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
public class UserRequest extends BaseRequest {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
