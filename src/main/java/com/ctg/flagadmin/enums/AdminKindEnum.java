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
     * 一级会务室管理员
     */
    FIRST_COUNCIL_ADMIN(3),

    /**
     * 二级会务室管理员
     */
    SECOND_COUNCIL_ADMIN(4),

    /**
     * 众创申请入驻管理员
     */
    SPACE_APPLY_ADMIN(5);

    private Integer value ;//状态码

    AdminKindEnum(Integer value){
        this.value=value;
    }

    public Integer getValue(){
        return value;
    }

}
