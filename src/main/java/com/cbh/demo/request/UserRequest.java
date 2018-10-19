package com.cbh.demo.request;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
public class UserRequest extends BaseRequest {

    private Integer id;

    private String username;

    private String sign;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
