package com.mall.dao.user;

import com.mall.orm.user.User;

import java.io.Serializable;

/**
 * Created by cjz on 2014/8/8.
 */
public interface IUserDao {
    public User getUserByName(String loginName);
    public Serializable save(User user);
}
