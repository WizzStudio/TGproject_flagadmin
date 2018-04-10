package com.ctg.flagadmin.pojo.dto;

import com.ctg.flagadmin.pojo.dto.CouncilOrderListDtoComponent.ListCompletedTimeDto;
import com.ctg.flagadmin.pojo.dto.CouncilOrderListDtoComponent.ListOrderItemDto;

import java.util.Date;
import java.util.List;

public class CouncilOrderListDto {
    private Date date;
    private List<ListOrderItemDto> orderItem;
    private List<ListCompletedTimeDto> completedTime;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ListOrderItemDto> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<ListOrderItemDto> orderItem) {
        this.orderItem = orderItem;
    }

    public List<ListCompletedTimeDto> getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(List<ListCompletedTimeDto> completedTime) {
        this.completedTime = completedTime;
    }
}
