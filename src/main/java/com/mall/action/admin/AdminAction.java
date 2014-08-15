package com.mall.action.admin;

import com.mall.orm.admin.Admin;
import com.mall.service.admin.IAdminService;
import com.mall.util.Identity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Jayson on 2014/8/10.
 */
@Controller("AdminAction")
@RequestMapping("/admin")
public class AdminAction {
    private static final String LOGIN_JSP = "jsp/admin/login";
    private static final String MAIN_JSP = "jsp/admin/main";
    private static final String WELCOME_JSP = "jsp/admin/welcome";

    @Resource(name = "AdminService")
    private IAdminService adminService;

    @RequestMapping("/loginInit")
    public String loginInit(){
        return LOGIN_JSP;
    }
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute Admin admin , BindingResult result , HttpSession session){
        if(result.hasErrors()){
            return LOGIN_JSP;
        }

        Admin _admin = adminService.getAdminByName(admin.getLoginName());
        if(_admin == null){
            result.addError(new FieldError("admin" , "loginName" , "登陆名错误"));
            return LOGIN_JSP;
        }

        if(!_admin.getLoginPwd().equals(admin.getLoginPwd())){
            result.addError(new FieldError("admin" , "loginPwd" , "登陆密码错误"));
            return LOGIN_JSP;
        }

        session.setAttribute(Identity.admin.getIdentity() , admin.getId());

        return MAIN_JSP;
    }
    @RequestMapping("/main")
    public String main(){
        return MAIN_JSP;
    }
    @RequestMapping("/welcome")
    public String welcome(){
        return WELCOME_JSP;
    }
}