package com.ctg.flagadmin.service;

public interface MessageService {
    /**
     * 保存管理员提交的信息，会自动删除以前的信息
     */
    void saveMessage(Integer userId, Integer kind, String content);

    String getExistedCouncilMessage();
}
