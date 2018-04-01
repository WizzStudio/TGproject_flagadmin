package com.ctg.flagadmin.pojo.dto;

import java.util.ArrayList;


public class PlaceDetailDto {

    private String description;

    private ArrayList<TimeSlotDto> successTime;//成功预约时间段列表

    private ArrayList<TimeSlotDto> timing;//正在预约时间段列表

    public PlaceDetailDto(String description){
        this.description = description;
        this.successTime = new ArrayList<>();
        this.timing = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<TimeSlotDto> getSuccessTime() {
        return successTime;
    }

    public ArrayList<TimeSlotDto> getTiming() {
        return timing;
    }

}
