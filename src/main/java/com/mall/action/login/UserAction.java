package com.mall.action.login;

import com.mall.orm.user.User;
import com.mall.service.user.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by jayson on 2014/8/8.
 */
@Controller("UserAction")
@Scope("prototype")
@RequestMapping("/user")
public class UserAction {
    @Resource(name = "UserService")
    private IUserService userService;
    @RequestMapping("/regist")
    public String  regist(@Validated User user, String confirmPwd){
        if(!user.getLoginPwd().equals(confirmPwd)){
            return "regist";
        }
        User _user = userService.getUserByName(user.getLoginName());

        return "login";
    }
    public String login(@Validated User user){
        return "main";
    }
}
