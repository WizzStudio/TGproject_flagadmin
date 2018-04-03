package com.ctg.flagadmin.service.Impl;

import com.ctg.flagadmin.dao.AdminDao;
import com.ctg.flagadmin.pojo.entity.Admin;
import com.ctg.flagadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    private final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin getByUsername(String username) {
        return adminDao.getByUsername(username);
    }
}
