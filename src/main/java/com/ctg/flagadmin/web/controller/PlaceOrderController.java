package com.ctg.flagadmin.web.controller;

import com.ctg.flagadmin.enums.PlaceOrderStateEnum;
import com.ctg.flagadmin.pojo.dto.PlaceOrderDetailDto;
import com.ctg.flagadmin.pojo.dto.PlaceOrderListItemDto;
import com.ctg.flagadmin.pojo.dto.ResponseDto;
import com.ctg.flagadmin.pojo.entity.PlaceOrder;
import com.ctg.flagadmin.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/placeOrder")
public class PlaceOrderController {
    private final PlaceOrderService placeOrderService;

    @Autowired
    public PlaceOrderController(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    /**
     * 获得订单详情
     * @param oid 订单id
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.GET)
    public ResponseDto getPlaceOrderDetail(@PathVariable(name = "oid") Integer oid) {
        PlaceOrderDetailDto detail = placeOrderService.getPlaceOrderDetailById(oid);
        return ResponseDto.succeed(null, detail);
    }

    /**
     * 获得正在审核的列表
     * 依据管理员的种类
     * 有问题！！！！！！
     */
    @RequestMapping(value = "/pending", method = RequestMethod.GET)
    public ResponseDto getPendingPlaceOrderList(HttpServletRequest request) {
        Integer role = (Integer) request.getAttribute("role");
        List<PlaceOrderListItemDto> orders = placeOrderService.findAllByStateAndAdminKind(
                PlaceOrderStateEnum.PENDING.getValue(), role);
        return ResponseDto.succeed(null, orders);
    }

    /**
     * 获得已经审核的列表
     * 依据管理员的种类
     * 有问题！！！！！！
     */
    @RequestMapping(value = "/completed", method = RequestMethod.GET)
    public ResponseDto getCompletedPlaceOrderList(HttpServletRequest request) {
        Integer role = (Integer) request.getAttribute("role");
        List<PlaceOrderListItemDto> orders = placeOrderService.findAllByStateAndAdminKind(
                PlaceOrderStateEnum.ACCEPTED.getValue(), role);
        return ResponseDto.succeed(null, orders);
    }
}
