package com.ctg.flagadmin.web.controller;

import com.ctg.flagadmin.pojo.dto.CouncilOrderDetailDto;
import com.ctg.flagadmin.pojo.dto.CouncilOrderListDto;
import com.ctg.flagadmin.pojo.dto.OptionDto;
import com.ctg.flagadmin.pojo.dto.ResponseDto;
import com.ctg.flagadmin.pojo.entity.CouncilOrder;
import com.ctg.flagadmin.service.CouncilOrderService;
import com.ctg.flagadmin.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;

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
        CouncilOrderDetailDto co = councilOrderService.getDetailById(oid);
        return ResponseDto.succeed(null, co);
    }

    /**
     * 获得未审核的会务室申请列表
     */
    @RequestMapping(value = "/pending/{cid}", method = RequestMethod.GET)
    public ResponseDto getPendingCouncilOrderList(@PathVariable("cid") Integer cid,
                                                  HttpServletRequest request) {
        Integer role = (Integer) request.getAttribute(JWTUtil.USER_ROLE_KEY);
        List<CouncilOrderListDto> colds = councilOrderService.listPendingOrderByRole(cid, role);
        return ResponseDto.succeed(null, colds);
    }

    /**
     * 获得已审核的会务室申请列表
     */
    @RequestMapping(value = "/completed", method = RequestMethod.GET)
    public ResponseDto getCompletedCouncilOrderList(HttpServletRequest request) {
        Integer role = (Integer) request.getAttribute(JWTUtil.USER_ROLE_KEY);
        List<Map<String, Object>> ccos = councilOrderService.listCompletedOrderByRole(role);
        return ResponseDto.succeed(null, ccos);
    }

    /**
     * 获得会务室申请数量
     */
    @GetMapping(value = "/count")
    public ResponseDto countCouncilOrder(HttpServletRequest request) {
        Integer role = (Integer) request.getAttribute(JWTUtil.USER_ROLE_KEY);
        List<Map<String, Object>> count = councilOrderService.listCountByRole(role);
        return ResponseDto.succeed(null, count);
    }

    /**
     * 审批会务室
     */
    @PutMapping(value = "/check/{oid}")
    public ResponseDto checkCouncilOrder(@RequestParam(name = "feedback", defaultValue = "无") String feedback,
                                         @RequestParam(name = "state") Integer state,
                                         @PathVariable(name = "oid") Integer oid,
                                         HttpServletRequest request) {
        Integer role = (Integer) request.getAttribute(JWTUtil.USER_ROLE_KEY);
        councilOrderService.checkByRole(oid, feedback, state, role);
        return ResponseDto.succeed();
    }
}
