package com.ctg.flagadmin.dao;

import com.ctg.flagadmin.pojo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer> {
    Message getById(Integer id);
}
