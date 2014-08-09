package com.mall.orm.user;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by jayson on 2014/8/8.
 */
@Entity
public class User{
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotEmpty(message = "登陆名不能为空")
    @Column(name = "loginName")
    private String loginName;

    @NotNull
    @Pattern(regexp = "[0-9],[a-z],[A-Z]{6,20}" , message = "密码必须为6－20位字母或数字组合")
    @Column(name = "loginPwd")
    private String loginPwd;

    /**getter、setter方法**/
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
