package com.ctg.flagadmin.enums;

public enum SpaceApplyStateEnum {
    /**
     * 审核中
     */
    PENDING(0),

    /**
     * 审核通过
     */
    ACCEPTING(1),

    /**
     *
     */
    REFUSED(2),

    /**
     * 已删除
     */
    DELETED(3);

    private Integer value;

    SpaceApplyStateEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
