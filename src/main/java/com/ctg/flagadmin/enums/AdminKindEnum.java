package com.ctg.flagadmin.enums;

public enum AdminKindEnum {
    /**
     * 二级管理员
     */
    ORDINARY_ROOM_SECONDARY_ADMIN(0),

    /**
     * 一级管理员
     */
    ORDINARY_ROOM_PRIMARY_ADMIN(1),

    /**
     * 众创空间管理员
     */
    CREATE_SPACE_ADMIN(2),

    /**
     * 会务室管理员
     */
    CONFERENCE_ROOM_ADMIN(3),

    /**
     * 众创申请入驻管理员
     */
    SPACE_APPLY_ADMIN(4);

    private Integer value ;//状态码

    AdminKindEnum(Integer value){
        this.value=value;
    }

    public Integer getValue(){
        return value;
    }

}
