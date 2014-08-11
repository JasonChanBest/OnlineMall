package com.mall.action.user;

import com.mall.orm.user.User;
import com.mall.service.user.IUserService;
import com.mall.util.Identity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    public String  regist(@Valid @ModelAttribute("user") User user , BindingResult result , @RequestParam String confirmPwd , HttpSession session , Model model){

        if(result.hasErrors()){
            return REGIST_JSP;
        }

        if(!user.getLoginPwd().equals(confirmPwd)){
            model.addAttribute("confirmPwdErr" , "两次输入密码不一致");
            return REGIST_JSP;
        }
        User _user = userService.getUserByName(user.getLoginName());
        if(_user != null){
            result.addError(new FieldError("user", "loginName", "用户名已存在"));
            return REGIST_JSP;
        }

        Serializable id = userService.save(user);
        session.setAttribute(Identity.user.getIdentity() , id);

        return INDEX_JSP;
    }

    public String loginInit(HttpSession session){
        Object id = session.getAttribute("id");
        if(id != null){
            return INDEX_JSP;
        }
        return LOGIN_JSP;
    }

    public String login(@Valid User user , HttpSession session , Model model , BindingResult result){
        if(result.hasErrors()){
            return LOGIN_JSP;
        }

        User _user = userService.getUserByName(user.getLoginName());
        if(_user == null){
            model.addAttribute("loginNameErr" , "用户名不存在");
            return LOGIN_JSP;
        }

        if(!user.getLoginPwd().equals(_user.getLoginPwd())){
            model.addAttribute("loginPwdErr" , "密码错误");
            return LOGIN_JSP;
        }

        session.setAttribute(Identity.user.getIdentity() , _user.getId());

        return INDEX_JSP;
    }
}
