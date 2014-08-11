package com.mall.dao.admin.impl;

import com.mall.dao.admin.IAdminDao;
import com.mall.orm.admin.Admin;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jayson on 2014/8/10.
 */
@Repository("AdminDao")
public class AdminDao implements IAdminDao {
    @Resource(name = "HibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public Admin getAdminByName(String loginName) {
        List<Admin> admins = hibernateTemplate.find("from Admin where loginName=?", loginName);
        return admins.isEmpty() ? null : admins.get(0);
    }
}
