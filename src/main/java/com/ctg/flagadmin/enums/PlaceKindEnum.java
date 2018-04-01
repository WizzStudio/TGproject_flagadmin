package com.ctg.flagadmin.enums;

public enum PlaceKindEnum {
    /**
     * 普通场地预约
     */
    ORDINARY_ROOM(0),

    /**
     * 众创空间入住
     */
    CREATE_SPACE(1),

    /**
     * 会务室申请
     */
    CONFERENCE_ROOM(2);

    private Integer value;

    PlaceKindEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}
