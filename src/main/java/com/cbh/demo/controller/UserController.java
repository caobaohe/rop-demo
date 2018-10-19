package com.cbh.demo.controller;

import com.cbh.demo.model.User;
import com.cbh.demo.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("get")
    public User get(Integer id) {
        User user = userService.getUserById(id);
        Gson gson = new Gson();
        logger.info(gson.toJson(user));
        return user;
    }

    @ResponseBody
    @RequestMapping("getString")
    public String getString(String str) {
        logger.info(str);
        return str;
    }
}
