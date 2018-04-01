package com.ctg.flagadmin.pojo.dto;

public class PlaceDto {

    private Integer id;//场地id

    private String name;//场地名称

    private Integer count;//本周预约次数

    private Integer personOrderNum;//正在预约人数

    public PlaceDto(){}

    public PlaceDto(Integer id,String name,Integer count){
        this.id = id;
        this.name = name;
        this.count = count;
        this.personOrderNum = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPersonOrderNum() {
        return personOrderNum;
    }

    public void setPersonOrderNum(Integer personOrderNum) {
        this.personOrderNum = personOrderNum;
    }
}
