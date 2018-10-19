package com.cbh.demo.test;

import com.cbh.demo.request.UserRequest;
import com.cbh.demo.response.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.rop.response.ErrorResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
public class DemoTest {


    public static String getSign(String appSecret, Map<String, Object> map) {
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        StringBuffer sb = new StringBuffer(appSecret);
        for (String key : list) {
            sb.append(key);
            sb.append(map.get(key));
        }
        sb.append(appSecret);
        return DigestUtils.shaHex(sb.toString());
    }

    @Test
    public void test() throws IOException {
        String serverUrl = "http://127.0.0.1:9090/router";
        String appKey = "01";
        String appSecret = "oZyGs1Vhtbz1EyaMz2aQ1Nag";
        DefaultRopClient ropClient = new DefaultRopClient(serverUrl, appKey, appSecret);
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("A");
        Map<String, Object> map = new HashMap<>();
        map.put("appKey", appKey);
        map.put("username", userRequest.getUsername());
        map.put("method", "user.get");
        map.put("v", "1.0");
        String sign = getSign(appSecret, map);
        userRequest.setSign(sign);
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

    @Test
    public void testUserGet() throws IOException {
        String serverUrl = "http://127.0.0.1:9090/router";
        String appKey = "01";
        String appSecret = "";
        DefaultRopClient ropClient = new DefaultRopClient(serverUrl, appKey, appSecret);
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("A");
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
