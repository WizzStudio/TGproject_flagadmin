package com.ctg.flagadmin.dao;

import com.ctg.flagadmin.pojo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
    Admin getByUsername(String username);
}
