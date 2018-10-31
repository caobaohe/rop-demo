package com.cbh.demo.controller;

import com.cbh.demo.model.User;
import com.cbh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/31
 * @Description:
 */
@RequestMapping("dobbo")
public class DubboController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("get")
    public User get(Integer id) {
        User user = userService.getUserById(id);
        return user;
    }
}
