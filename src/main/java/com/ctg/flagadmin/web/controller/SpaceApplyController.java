package com.ctg.flagadmin.web.controller;

import com.ctg.flagadmin.enums.SpaceApplyStateEnum;
import com.ctg.flagadmin.pojo.dto.ResponseDto;
import com.ctg.flagadmin.pojo.dto.SpaceApplyListItemDto;
import com.ctg.flagadmin.pojo.entity.SpaceApply;
import com.ctg.flagadmin.service.SpaceApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spaceApply")
public class SpaceApplyController {
    private final SpaceApplyService spaceApplyService;

    @Autowired
    public SpaceApplyController(SpaceApplyService spaceApplyService) {
        this.spaceApplyService = spaceApplyService;
    }

    /**
     * 获得申请页详情
     * @param aid 申请项id
     */
    @RequestMapping(value = "/{aid}", method = RequestMethod.GET)
    public ResponseDto getSpaceApplyDetail(@PathVariable(value = "aid") Integer aid) {
        SpaceApply spaceApply = spaceApplyService.getSpaceApplyDetailById(aid);
        if (spaceApply == null) {
            return ResponseDto.failed("space apply id is wrong.");
        } else {
            return ResponseDto.succeed(null, spaceApply);
        }
    }

    /**
     * 审批入住申请
     */
    @RequestMapping(value = "/{aid}", method = RequestMethod.PUT)
    public ResponseDto updateSpaceApply(@PathVariable(name = "aid") Integer aid,
                                        @RequestParam(name = "feedback") String feedback,
                                        @RequestParam(name = "state") Integer state) {
        spaceApplyService.audit(aid, state, feedback);

        return ResponseDto.succeed();
    }

    /**
     * 获得申请入驻的数量
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseDto countPendingSpaceApply() {
        Integer count = spaceApplyService.countPending();
        return ResponseDto.succeed(null, count);
    }

    /**
     * 获得未审核的众创空间申请的列表
     */
    @RequestMapping(value = "/pending", method = RequestMethod.GET)
    public ResponseDto getPendingSpaceApplyList() {
        List<SpaceApplyListItemDto> applies = spaceApplyService.findAllByState(SpaceApplyStateEnum.PENDING.getValue());
        return ResponseDto.succeed(null, applies);
    }

    /**
     * 获得已审核的众创空间列表
     */
    @RequestMapping(value = "/completed", method = RequestMethod.GET)
    public ResponseDto getCompletedSpaceApply() {
        List<Integer> states = new ArrayList<>();
        // 已完成的状态有两个，审核通过，审核失败
        states.add(SpaceApplyStateEnum.ACCEPTING.getValue());
        states.add(SpaceApplyStateEnum.REFUSED.getValue());
        List<SpaceApplyListItemDto> applies = spaceApplyService.findAllByStateIn(states);
        return ResponseDto.succeed(null, applies);
    }
}
