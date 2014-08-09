package com.mall.orm.user;

import javax.persistence.*;

/**
 * Created by jayson on 2014/8/8.
 */
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "loginName")
    private String loginName;

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
}
