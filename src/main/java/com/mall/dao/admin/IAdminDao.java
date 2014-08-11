package com.mall.dao.admin;

import com.mall.orm.admin.Admin;

/**
 * Created by Jayson on 2014/8/10.
 */
public interface IAdminDao {
    public Admin getAdminByName(String loginName);
}
