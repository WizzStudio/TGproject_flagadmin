package com.ctg.flagadmin.enums;

public enum MessageStateEnum {
    EXISTING(1),
    DELETED(0);

    private Integer value;

    MessageStateEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
