package com.ctg.flagadmin.dao;

import com.ctg.flagadmin.pojo.entity.CouncilOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface CouncilOrderDao extends JpaRepository<CouncilOrder, Integer> {
    CouncilOrder getById(Integer id);

    List<CouncilOrder> findAllByStateInOrderByUpdateTimeDesc(Collection<Integer> state);

    List<CouncilOrder> findAllByStateInOrderByCid(List<Integer> states);

    /**
     * 获得状态在states中的时间大于给定时间的正在审核的订单
     * 并且按照时间排序
     * @param states 目标状态集合
     * @param startTime 分界线
     */
    List<CouncilOrder> findAllByCidAndStateInAndStartTimeGreaterThanOrderByStartTime(Integer id, List<Integer> states, Date startTime);
}
