package com.mall.service.admin.impl;

import com.mall.dao.admin.IAdminDao;
import com.mall.orm.admin.Admin;
import com.mall.service.admin.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Jayson on 2014/8/10.
 */
@Service("AdminService")
public class AdminService implements IAdminService {
    @Resource(name = "AdminDao")
    private IAdminDao adminDao;
    @Override
    public Admin getAdminByName(String loginName) {
        return adminDao.getAdminByName(loginName);
    }
}
