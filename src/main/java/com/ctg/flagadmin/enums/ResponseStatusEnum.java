package com.ctg.flagadmin.enums;

public enum ResponseStatusEnum {
    SUCCEED(0),
    FAILED(1);

    private Integer value;

    ResponseStatusEnum(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
