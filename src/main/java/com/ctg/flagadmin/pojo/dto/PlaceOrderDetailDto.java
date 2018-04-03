package com.ctg.flagadmin.pojo.dto;

import java.util.Date;

public class PlaceOrderDetailDto {
    private String username;
    private Integer orderId;
    private String placeName;
    private Integer status;
    private Date startTime;
    private Date endTime;
    private String feedback;
    private String activity;
    private String admin;
    private String phone;
    private String people;

    private String prop;

    private String content;

    private String department;

    public PlaceOrderDetailDto(String username, Integer orderId, String placeName, Integer status, Date startTime, Date endTime, String feedback, String activity, String admin, String phone, String people, String prop, String content, String department) {
        this.username = username;
        this.orderId = orderId;
        this.placeName = placeName;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.feedback = feedback;
        this.activity = activity;
        this.admin = admin;
        this.phone = phone;
        this.people = people;
        this.prop = prop;
        this.content = content;
        this.department = department;
    }

    public PlaceOrderDetailDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
