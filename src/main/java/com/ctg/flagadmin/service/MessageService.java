package com.ctg.flagadmin.service;

public interface MessageService {
    void saveMessage(Integer userId, Integer kind, String content);
}
