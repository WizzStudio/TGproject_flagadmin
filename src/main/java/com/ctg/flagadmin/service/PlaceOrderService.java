package com.ctg.flagadmin.service;

import com.ctg.flagadmin.pojo.dto.PlaceOrderDetailDto;
import com.ctg.flagadmin.pojo.dto.PlaceOrderListItemDto;

import java.util.List;

public interface PlaceOrderService {
    PlaceOrderDetailDto getPlaceOrderDetailById(Integer oid);

    List<PlaceOrderListItemDto> findAllByStateAndAdminKind(Integer state, Integer adminKind);
}
