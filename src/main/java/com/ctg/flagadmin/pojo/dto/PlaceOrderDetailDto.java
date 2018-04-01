package com.ctg.flagadmin.pojo.dto;

import java.util.Date;

public class PlaceOrderDetailDto {
    private Integer orderId;
    private String placeName;
    private Integer status;
    private Date startTime;
    private Date endTime;
    private String feedback;

    public PlaceOrderDetailDto(Integer orderId, String placeName, Integer status, Date startTime, Date endTime, String feedback) {
        this.orderId = orderId;
        this.placeName = placeName;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.feedback = feedback;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
