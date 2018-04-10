package com.ctg.flagadmin.dao;

import com.ctg.flagadmin.pojo.entity.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PlaceOrderDao extends JpaRepository<PlaceOrder, Integer> {
    PlaceOrder getById(Integer id);

    /**
     * 根据这个管理员能够管理的场地pids，
     * 查找目标状态的订单
     */
    List<PlaceOrder> findAllByStateAndPidIn(Integer state, Collection<Integer> pids);
    
}
