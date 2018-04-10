package com.ctg.flagadmin.service;

import com.ctg.flagadmin.pojo.dto.SpaceApplyListItemDto;
import com.ctg.flagadmin.pojo.entity.SpaceApply;

import java.util.List;

public interface SpaceApplyService {
    SpaceApply getSpaceApplyDetailById(Integer oid);

    List<SpaceApplyListItemDto> findAllByState(Integer state);

    List<SpaceApplyListItemDto> findAllByStateIn(List<Integer> states);

    /**
     * 正在申请入住的数量
     */
    Integer countPending();

    /**
     * 审批入住
     */
    void check(Integer aid, Integer state, String feedback);
}
