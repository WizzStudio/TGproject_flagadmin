package com.ctg.flagadmin.pojo.dto;

import java.util.Date;

public class SpaceApplyListItemDto {
    private String teamName;
    private Integer id;
    private Date createTime;

    public SpaceApplyListItemDto(String teamName, Integer id, Date createTime) {
        this.teamName = teamName;
        this.id = id;
        this.createTime = createTime;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
