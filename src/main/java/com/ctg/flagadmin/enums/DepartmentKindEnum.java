package com.ctg.flagadmin.enums;


public enum DepartmentKindEnum {
    /**
     * 0 代表工作室预约
     */
    STUDIO(0),

    /**
     * 1 代表其他预约
     */
    ORGANIZATION(1);

    private Integer value ;
    DepartmentKindEnum(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
