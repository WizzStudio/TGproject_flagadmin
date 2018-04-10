package com.ctg.flagadmin.service;

import com.ctg.flagadmin.pojo.entity.Admin;

public interface AdminService {
    /**
     * 通过用户名获得用户
     */
    Admin getByUsername(String username);
}
