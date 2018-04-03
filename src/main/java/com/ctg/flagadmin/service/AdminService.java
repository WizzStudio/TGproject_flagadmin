package com.ctg.flagadmin.service;

import com.ctg.flagadmin.pojo.entity.Admin;

public interface AdminService {
    Admin getByUsername(String username);
}
