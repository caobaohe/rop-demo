package com.cbh.demo.controller;

import com.cbh.demo.request.UserRequest;
import com.cbh.demo.response.UserResponse;
import com.cbh.demo.rop.client.DemoRopClient;
import com.google.gson.Gson;
import com.rop.client.ClientRequest;
import com.rop.client.CompositeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
@Controller
@RequestMapping("user")
public class UserController {

    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("get")
    public CompositeResponse get(Integer id) {
        ClientRequest clientRequest = new DemoRopClient("01", "abcde").buildClientRequest();
        UserRequest request = new UserRequest();
        request.setId(1);
        CompositeResponse response = clientRequest.get(request, UserResponse.class, "user.get", "1.0");
        Gson gson = new Gson();
        logger.info(gson.toJson(response.getSuccessResponse()));
        return response;
    }

    @ResponseBody
    @RequestMapping("getString")
    public String getString(String str) {
        logger.info(str);
        return str;
    }
}
