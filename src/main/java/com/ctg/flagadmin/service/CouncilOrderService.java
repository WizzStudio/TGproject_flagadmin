package com.ctg.flagadmin.service;

import com.ctg.flagadmin.pojo.dto.CouncilOrderDetailDto;
import com.ctg.flagadmin.pojo.dto.CouncilOrderListDto;
import com.ctg.flagadmin.pojo.entity.CouncilOrder;

import java.util.List;
import java.util.Map;

public interface CouncilOrderService {
    /**
     * 获取会务室申请详情
     */
    CouncilOrder getById(Integer oid);

    CouncilOrderDetailDto getDetailById(Integer oid);

    /**
     * 通过角色获得不同的正在申请的会务室
     */
    List<CouncilOrderListDto> listPendingOrderByRole(Integer cid, Integer role);

    /**
     * 通过角色获得不同的已经完成的会务室
     */
    List<Map<String, Object>> listCompletedOrderByRole(Integer role);

    /**
     * 获得会务室正在申请的数量、名称、id
     */
    List<Map<String,Object>> listCountByRole(Integer role);

    /**
     * 修改表单，审核会务室申请
     */
    void checkByRole(Integer oid, String feedback, Integer state, Integer role);
}
