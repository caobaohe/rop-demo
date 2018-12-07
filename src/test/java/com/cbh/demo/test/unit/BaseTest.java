package com.cbh.demo.test.unit;

import com.alibaba.dubbo.common.json.JSONObject;
import com.cbh.demo.model.User;
import com.cbh.demo.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/12/3
 * @Description:
 */

public class BaseTest extends UnitilsJUnit4 {

    @SpringApplicationContext({"spring-context.xml", "spring-mybatis.xml"})
    private ApplicationContext applicationContext;

    @SpringBean("userServiceImpl")
    private UserService userService;

    @Test
    public void testUser() {
        User user = userService.getUserById(1);
        Gson gson = new Gson();
        System.out.println(gson.toJson(user));
        user.setName("AAA");
        System.out.println(gson.toJson(user));
        user.setAttr();
        System.out.println(gson.toJson(user));
        User user2 = userService.getUserById(1);
        System.out.println(gson.toJson(user2));
    }
}
