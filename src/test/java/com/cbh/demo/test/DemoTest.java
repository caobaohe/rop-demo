package com.cbh.demo.test;

import com.cbh.demo.request.UserRequest;
import com.cbh.demo.response.LogonResponse;
import com.cbh.demo.response.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.rop.response.ErrorResponse;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
public class DemoTest {

    @Test
    public void test() throws IOException {
        String serverUrl = "http://127.0.0.1:9090/router";
        String appKey = "01";
        String appSecret = "abcde";
        DefaultRopClient ropClient = new DefaultRopClient(serverUrl, appKey, appSecret);
        CompositeResponse response = ropClient.buildClientRequest().
                addParam("username", "AAAA").
                get(LogonResponse.class, "user.getSession", "1.0");
        boolean successful = response.isSuccessful();
        System.out.println(successful);
        if (successful) {
            LogonResponse logonResponse = ((LogonResponse) response.getSuccessResponse());
            System.out.println(logonResponse);
        } else {
            ErrorResponse errorResponse = response.getErrorResponse();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(errorResponse);
            System.out.println(json);
        }
    }

    @Test
    public void testUserGet() throws IOException {
        String serverUrl = "http://127.0.0.1:9090/router";
        String appKey = "01";
        String appSecret = "abcde";
        DefaultRopClient ropClient = new DefaultRopClient(serverUrl, appKey, appSecret);
        UserRequest userRequest = new UserRequest();
        userRequest.setId(1);
        CompositeResponse response = ropClient.buildClientRequest().get(userRequest, UserResponse.class, "user.get", "1.0");
        boolean successful = response.isSuccessful();
        System.out.println(successful);
        if (successful) {
            UserResponse userResponse = ((UserResponse) response.getSuccessResponse());
            System.out.println(userResponse);
        } else {
            ErrorResponse errorResponse = response.getErrorResponse();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(errorResponse);
            System.out.println(json);
        }
    }
}
