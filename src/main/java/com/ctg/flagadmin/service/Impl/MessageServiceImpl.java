package com.ctg.flagadmin.service.Impl;

import com.ctg.flagadmin.dao.MessageDao;
import com.ctg.flagadmin.enums.MessageKindEnum;
import com.ctg.flagadmin.enums.MessageStateEnum;
import com.ctg.flagadmin.pojo.entity.Message;
import com.ctg.flagadmin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    private MessageDao messageDao;

    @Autowired
    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public void saveMessage(Integer userId, Integer kind, String content) {
        Message m = messageDao.getByKindAndState(kind, MessageStateEnum.EXISTING.getValue());
        if (m != null) {
            m.setState(MessageStateEnum.DELETED.getValue());
            messageDao.save(m);
        }

        Message message = new Message();
        message.setAid(userId);
        message.setContent(content);
        message.setKind(kind);
        message.setState(MessageStateEnum.EXISTING.getValue());
        messageDao.save(message);
    }

    @Override
    public String getExistedCouncilMessage() {
        Message message = messageDao.getByKindAndState(MessageKindEnum.COUNCIL.getValue(), MessageStateEnum.EXISTING.getValue());
        if (message == null) return null;
        return message.getContent();
    }
}
