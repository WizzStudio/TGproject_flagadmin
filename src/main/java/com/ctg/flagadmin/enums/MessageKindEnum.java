package com.ctg.flagadmin.enums;

public enum  MessageKindEnum {
    /**
     * 星火众创空间信息
     */
    START_SPACE(0) ;

    private Integer value;

    MessageKindEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
