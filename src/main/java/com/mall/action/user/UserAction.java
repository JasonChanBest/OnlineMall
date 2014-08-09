package com.mall.action.user;

import com.mall.orm.user.User;
import com.mall.service.user.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by jayson on 2014/8/8.
 */
@Controller("UserAction")
@Scope("prototype")
@RequestMapping("/user")
public class UserAction {
    private static final String REGIST_JSP = "jsp/user/regist";
    private static final String LOGIN_JSP = "jsp/user/login";
    private static final String INDEX_JSP = "jsp/index";

    @Resource(name = "UserService")
    private IUserService userService;

    @RequestMapping("/registInit")
    public String registInit(){
        return REGIST_JSP;
    }

    @RequestMapping("/regist")
    public String  regist(@Validated User user, String confirmPwd , HttpSession session , Errors errors){

        if(errors.hasErrors()){
            return REGIST_JSP;
            errors.
        }

        if(!user.getLoginPwd().equals(confirmPwd)){
            return REGIST_JSP;
        }
        User _user = userService.getUserByName(user.getLoginName());
        if(_user != null){
            return REGIST_JSP;
        }

        Serializable id = userService.save(user);
        session.setAttribute("id" , id);

        return "login";
    }

    public String loginInit(HttpSession session){
        Object id = session.getAttribute("id");
        if(id != null){
            return INDEX_JSP;
        }
        return LOGIN_JSP;
    }

    public String login(@Validated User user){
        return INDEX_JSP;
    }
}
