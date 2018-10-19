package com.cbh.demo.rop;

import com.cbh.demo.model.User;
import com.cbh.demo.request.UserRequest;
import com.cbh.demo.response.UserResponse;
import com.cbh.demo.service.UserService;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
@ServiceMethodBean
public class UserRopService {

    @Autowired
    private UserService userService;

    @ServiceMethod(method = "user.get", version = "1.0", needInSession = NeedInSessionType.NO)
    public Object getUser(UserRequest request) {
        User user = userService.getUserById(request.getId());
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);
        return userResponse;
    }
}
