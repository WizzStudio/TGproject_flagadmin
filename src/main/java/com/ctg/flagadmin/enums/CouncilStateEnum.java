package com.ctg.flagadmin.enums;

public enum CouncilStateEnum {
    /**
     * 正在审核
     */
    PENDING(0),

    /**
     * 二级管理员拒绝
     */
    SECOND_REFUSED(1),

    /**
     * 一级管理员拒绝
     */
    FIRST_REFUSED(2),

    /**
     * 二级不确定
     */
    SECOND_NOT_SURE(3),

    /**
     * 二级通过
     */
    SECOND_ACCEPT(4),

    /**
     * 一级通过
     */
    FIRST_ACCEPT(5);

    private Integer value;

    CouncilStateEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
