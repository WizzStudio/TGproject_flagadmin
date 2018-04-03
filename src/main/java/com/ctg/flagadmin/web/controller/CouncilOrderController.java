package com.ctg.flagadmin.web.controller;

import com.ctg.flagadmin.pojo.dto.ResponseDto;
import com.ctg.flagadmin.service.CouncilOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/councilOrder")
public class CouncilOrderController {
    private final CouncilOrderService councilOrderService;

    @Autowired
    public CouncilOrderController(CouncilOrderService councilOrderService) {
        this.councilOrderService = councilOrderService;
    }

    /**
     * 获得会务室申请详情
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.GET)
    public ResponseDto getCouncilOrderDetail(@PathVariable(value = "oid") Integer oid) {
        return null;
    }

    /**
     * 获得未审核的会务室申请列表
     */
    @RequestMapping(value = "/pending", method = RequestMethod.GET)
    public ResponseDto getPendingCouncilOrderList() {
        return null;
    }

    /**
     * 获得已审核的会务室申请列表
     */
    @RequestMapping(value = "/completed", method = RequestMethod.GET)
    public ResponseDto getCompletedCouncilOrderList() {
        return null;
    }
}
