package com.mall.service.user.impl;

import com.mall.dao.user.IUserDao;
import com.mall.orm.user.User;
import com.mall.service.user.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jayson on 2014/8/8.
 */
@Service("UserService")
public class UserService implements IUserService {
    @Resource(name = "UserDao")
    private IUserDao userDao;
    @Override
    public User getUserByName(String loginName) {
        return userDao.getUserByName(loginName);
    }
}
