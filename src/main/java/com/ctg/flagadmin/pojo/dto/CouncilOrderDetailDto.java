package com.ctg.flagadmin.pojo.dto;

import com.ctg.flagadmin.pojo.entity.CouncilOrder;

import java.util.Date;

public class CouncilOrderDetailDto {
    private Integer id;
    private String teamName;
    private String activityName;
    private String activityForm;

    private Date startTime;

    private Date endTime;
    private Integer peopleSchoolIn;
    private Integer peopleSchoolOut;
    private String securityAdmin;
    private String phone;
    private String securityMeasure;
    private String equipment;

    private Integer state;
    private String feedback;

    private String councilName;

    public CouncilOrderDetailDto(CouncilOrder councilOrder) {
        this.id = councilOrder.getId();
        this.teamName = councilOrder.getTeamName();
        this.activityName = councilOrder.getActivityName();
        this.activityForm = councilOrder.getActivityForm();

        this.startTime = councilOrder.getStartTime();

        this.endTime = councilOrder.getEndTime();
        this.peopleSchoolIn = councilOrder.getPeopleSchoolIn();
        this.peopleSchoolOut = councilOrder.getPeopleSchoolOut();
        this.securityAdmin = councilOrder.getSecurityAdmin();
        this.phone = councilOrder.getPhone();
        this.securityMeasure = councilOrder.getSecurityMeasure();
        this.equipment = councilOrder.getEquipment();

        this.state = councilOrder.getState();
        this.feedback = councilOrder.getFeedback();
    }

    public void setCouncilName(String councilName) {
        this.councilName = councilName;
    }

    public Integer getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getActivityForm() {
        return activityForm;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Integer getPeopleSchoolIn() {
        return peopleSchoolIn;
    }

    public Integer getPeopleSchoolOut() {
        return peopleSchoolOut;
    }

    public String getSecurityAdmin() {
        return securityAdmin;
    }

    public String getPhone() {
        return phone;
    }

    public String getSecurityMeasure() {
        return securityMeasure;
    }

    public String getEquipment() {
        return equipment;
    }

    public Integer getState() {
        return state;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getCouncilName() {
        return councilName;
    }
}
