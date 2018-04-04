package com.ctg.flagadmin.web.controller;

import com.ctg.flagadmin.enums.MessageKindEnum;
import com.ctg.flagadmin.pojo.dto.ResponseDto;
import com.ctg.flagadmin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * 提交星火众创空间信息
     * 每次上传一个就前面所有的就都删除么？
     * @param content
     * @param request
     * @return
     */
    @RequestMapping(value = "/starSpace", method = RequestMethod.POST)
    public ResponseDto postStartSpaceMessage(@RequestParam(name = "content")String content,
                                             HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        messageService.saveMessage(userId, MessageKindEnum.START_SPACE.getValue(), content);
        return ResponseDto.succeed();
    }
}
