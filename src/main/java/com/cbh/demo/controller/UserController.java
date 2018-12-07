package com.cbh.demo.controller;

import com.cbh.demo.model.User;
import com.cbh.demo.request.UserRequest;
import com.cbh.demo.response.UserResponse;
import com.cbh.demo.rop.client.DemoRopClient;
import com.cbh.demo.service.UserService;
import com.google.gson.Gson;
import com.rop.client.ClientRequest;
import com.rop.client.CompositeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
@Api("用户相关")
@Controller
@RequestMapping("user")
public class UserController {

    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户（get）", notes = "根据用户id查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping("userById")
    public User getUserById(@ApiParam(required = true, hidden = false, value = "用户id", type = "测试type") Integer id) {
        User userById = userService.getUserById(id);
        return userById;
    }

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
    public User getString(String str) {
        logger.info(str);
        User user = userService.getUserById(1);
        return user;
    }

    @ResponseBody
    @RequestMapping("save")
    public String save(String str) {
        logger.info(str);
        User user = new User();
        user.setName(str);
        userService.save(user);
        return str;
    }
}
