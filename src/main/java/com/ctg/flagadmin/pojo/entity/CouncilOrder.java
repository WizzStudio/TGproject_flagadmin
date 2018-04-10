package com.ctg.flagadmin.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "council_order", schema = "flag")
public class CouncilOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teamName;
    private String activityName;
    private String activityForm;
    private Date startTime;
    private Date endTime;
    private Integer cid;
    private Integer peopleSchoolIn;
    private Integer peopleSchoolOut;
    private String securityAdmin;
    private String phone;
    private String securityMeasure;
    private String equipment;

    private Integer uid;
    private Integer state;
    private String feedback;

    private Date createTime;
    private Date updateTime;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityForm() {
        return activityForm;
    }

    public void setActivityForm(String activityForm) {
        this.activityForm = activityForm;
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPeopleSchoolIn() {
        return peopleSchoolIn;
    }

    public void setPeopleSchoolIn(Integer peopleSchoolIn) {
        this.peopleSchoolIn = peopleSchoolIn;
    }

    public Integer getPeopleSchoolOut() {
        return peopleSchoolOut;
    }

    public void setPeopleSchoolOut(Integer peopleSchoolOut) {
        this.peopleSchoolOut = peopleSchoolOut;
    }

    public String getSecurityAdmin() {
        return securityAdmin;
    }

    public void setSecurityAdmin(String securityAdmin) {
        this.securityAdmin = securityAdmin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecurityMeasure() {
        return securityMeasure;
    }

    public void setSecurityMeasure(String securityMeasure) {
        this.securityMeasure = securityMeasure;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}



