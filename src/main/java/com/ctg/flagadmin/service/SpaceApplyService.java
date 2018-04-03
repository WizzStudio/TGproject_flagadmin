package com.ctg.flagadmin.service;

import com.ctg.flagadmin.pojo.dto.SpaceApplyListItemDto;
import com.ctg.flagadmin.pojo.entity.SpaceApply;

import java.util.List;

public interface SpaceApplyService {
    SpaceApply getSpaceApplyDetailById(Integer oid);

    List<SpaceApplyListItemDto> findAllByState(Integer state);

    List<SpaceApplyListItemDto> findAllByStateIn(List<Integer> states);
}
