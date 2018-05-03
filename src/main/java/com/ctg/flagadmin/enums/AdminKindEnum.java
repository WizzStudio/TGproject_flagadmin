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
     * 一级会务室管理员,权限高于二级会务室管理员,能上传场地
     */
    FIRST_COUNCIL_ADMIN(3),

    /**
     * 二级会务室管理员,只能查看不能上传
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
