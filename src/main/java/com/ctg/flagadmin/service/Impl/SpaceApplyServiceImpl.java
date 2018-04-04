package com.ctg.flagadmin.service.Impl;

import com.ctg.flagadmin.dao.SpaceApplyDao;
import com.ctg.flagadmin.enums.SpaceApplyStateEnum;
import com.ctg.flagadmin.pojo.dto.SpaceApplyListItemDto;
import com.ctg.flagadmin.pojo.entity.SpaceApply;
import com.ctg.flagadmin.service.SpaceApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SpaceApplyServiceImpl implements SpaceApplyService{
    private final SpaceApplyDao spaceApplyDao;

    @Autowired
    public SpaceApplyServiceImpl(SpaceApplyDao spaceApplyDao) {
        this.spaceApplyDao = spaceApplyDao;
    }

    @Override
    public SpaceApply getSpaceApplyDetailById(Integer oid) {
        return spaceApplyDao.getById(oid);
    }

    @Override
    public List<SpaceApplyListItemDto> findAllByState(Integer state) {
        List<SpaceApply> applies = spaceApplyDao.findAllByState(state);
        List<SpaceApplyListItemDto> items = new ArrayList<>();
        for (SpaceApply apply: applies) {
            items.add(new SpaceApplyListItemDto(apply.getTeamName(), apply.getId(), apply.getCreateTime()));
        }
        items.sort(Comparator.comparing(SpaceApplyListItemDto::getCreateTime));
        return items;
    }

    @Override
    public List<SpaceApplyListItemDto> findAllByStateIn(List<Integer> states) {
        List<SpaceApply> applies = spaceApplyDao.findAllByStateIn(states);
        List<SpaceApplyListItemDto> items = new ArrayList<>();
        for (SpaceApply apply: applies) {
            items.add(new SpaceApplyListItemDto(apply.getTeamName(), apply.getId(), apply.getCreateTime()));
        }
        items.sort(Comparator.comparing(SpaceApplyListItemDto::getCreateTime));
        return items;
    }

    @Override
    public void audit(Integer aid, Integer state, String feedback) {
        SpaceApply spaceApply = spaceApplyDao.getById(aid);
        spaceApply.setState(state);
        spaceApply.setFeedback(feedback);
        spaceApplyDao.save(spaceApply);
    }

    @Override
    public Integer countPending() {
        return spaceApplyDao.countByState(SpaceApplyStateEnum.PENDING.getValue());
    }
}
