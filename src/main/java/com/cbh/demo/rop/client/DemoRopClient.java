package com.cbh.demo.rop.client;

import com.cbh.demo.request.LogonRequest;
import com.cbh.demo.response.LogonResponse;
import com.rop.client.ClientRequest;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/23
 * @Description:
 */
public class DemoRopClient {

    public static final String SERVER_URL = "http://localhost:9090/router";

    private DefaultRopClient ropClient;

    /**
     * 创建客户端对象
     *
     * @param appKey
     * @param secret
     */
    public DemoRopClient(String appKey, String secret) {
        ropClient = new DefaultRopClient(SERVER_URL, appKey, secret);
        ropClient.setFormatParamName("messageFormat");
//        ropClient.addRopConvertor(new TelephoneConverter());
    }

    /**
     * 登录系统
     *
     * @return
     */
    public String logon(String username, String password) {
        LogonRequest ropRequest = new LogonRequest();
        ropRequest.setUsername("tomson");
        ropRequest.setPassword("123456");
        CompositeResponse response = ropClient.buildClientRequest().get(ropRequest, LogonResponse.class, "user.logon", "1.0");
        String sessionId = ((LogonResponse) response.getSuccessResponse()).getSessionId();
        ropClient.setSessionId(sessionId);
        return sessionId;
    }

    public void logout() {
        ropClient.buildClientRequest().get(LogonResponse.class, "user.logout", "1.0");
    }

    public ClientRequest buildClientRequest() {
        return ropClient.buildClientRequest();
    }
}
