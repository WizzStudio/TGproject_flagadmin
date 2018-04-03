package com.ctg.flagadmin.pojo.dto;

public class PlaceOrderListItemDto {
    private String placeName;
    private String department;
    private Integer id;

    public PlaceOrderListItemDto(String placeName, String department, Integer id) {
        this.placeName = placeName;
        this.department = department;
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
