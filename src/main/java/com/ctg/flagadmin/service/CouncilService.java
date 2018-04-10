package com.ctg.flagadmin.service;

import com.ctg.flagadmin.pojo.entity.Place;

public interface CouncilService {
    /**
     * 通过id获得会务室场地信息
     */
    Place getById(Integer id);

    void save(Place place);
}
