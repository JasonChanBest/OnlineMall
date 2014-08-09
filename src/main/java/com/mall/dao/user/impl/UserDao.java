package com.mall.dao.user.impl;

import com.mall.dao.user.IUserDao;
import com.mall.orm.user.User;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jayson on 2014/8/8.
 */
@Repository("UserDao")
public class UserDao implements IUserDao {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public User getUserByName(String loginName) {
        List<User> list = hibernateTemplate.find("from User where loginName=?" , loginName);
        return list.isEmpty() ? null : list.get(0);
    }
}
