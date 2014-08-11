package com.mall.service.admin;

import com.mall.orm.admin.Admin;

/**
 * Created by Jayson on 2014/8/10.
 */
public interface IAdminService {
    public Admin getAdminByName(String loginName);
}
