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
    ACCEPTED_DELETED(3),

    /**
     * 未审核删除
     */
    PENDING_DELETED(4),

    /**
     * 审核失败删除
     */
    REFUSED_DELETED(5);

    private Integer value;

    SpaceApplyStateEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
