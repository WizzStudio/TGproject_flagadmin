package com.ctg.flagadmin.web.controller;

import com.ctg.flagadmin.enums.MessageKindEnum;
import com.ctg.flagadmin.enums.MessageStateEnum;
import com.ctg.flagadmin.pojo.dto.ResponseDto;
import com.ctg.flagadmin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * 提交星火众创空间信息
     * 每次上传一个就前面所有的就都删除
     */
    @RequestMapping(value = "/starSpace", method = RequestMethod.POST)
    public ResponseDto postStartSpaceMessage(@RequestParam(name = "content")String content,
                                             HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        messageService.saveMessage(userId, MessageKindEnum.START_SPACE.getValue(), content);
        return ResponseDto.succeed();
    }

    /**
     * 获得当前会务室提醒信息
     */
    public ResponseDto getCouncilMessage() {
        String message = messageService.getExistedCouncilMessage();
        return ResponseDto.succeed(null, message);
    }

    /**
     * 提交会务室提醒信息
     */
    @PostMapping(value = "/council")
    public ResponseDto postCouncilMessage(@RequestParam(name = "content") String content,
                                          HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        messageService.saveMessage(userId, MessageKindEnum.COUNCIL.getValue(), content);
        return ResponseDto.succeed();
    }
}
