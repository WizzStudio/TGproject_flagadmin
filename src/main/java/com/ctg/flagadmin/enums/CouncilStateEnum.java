package com.ctg.flagadmin.enums;

public enum CouncilStateEnum {
    PENDING(0),
    SECOND_REFUSED(1),
    FIRST_REFUSED(2),
    SECOND_NOT_SURE(3),
    SECOND_ACCEPT(4),
    FIRST_ACCEPT(5);

    private Integer value;

    CouncilStateEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
