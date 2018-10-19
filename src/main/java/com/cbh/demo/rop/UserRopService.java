package com.cbh.demo.rop;

import com.cbh.demo.model.User;
import com.cbh.demo.request.LogonRequest;
import com.cbh.demo.request.UserRequest;
import com.cbh.demo.response.LogonResponse;
import com.cbh.demo.response.UserResponse;
import com.cbh.demo.rop.session.DemoSession;
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

    @ServiceMethod(method = "user.getSession", version = "1.0", needInSession = NeedInSessionType.NO)
    public Object getSession(LogonRequest request) {
        DemoSession session = new DemoSession();
        session.setAttribute("username", request.getUsername());
        String sessionId = String.valueOf(session.hashCode());
        request.getRopRequestContext().addSession(sessionId, session);
        LogonResponse response = new LogonResponse();
        response.setSessionId(sessionId);
        return response;
    }

    @ServiceMethod(method = "user.get", version = "1.0", needInSession = NeedInSessionType.NO)
    public Object getUser(UserRequest request) {
        User user = null;//userService.getUserById(request.getId());
        UserResponse userResponse = new UserResponse();
        return userResponse;
    }
}
