package com.ctg.flagadmin.web.controller;

import com.ctg.flagadmin.enums.PlaceKindEnum;
import com.ctg.flagadmin.pojo.dto.ResponseDto;
import com.ctg.flagadmin.pojo.entity.Place;
import com.ctg.flagadmin.service.CouncilService;
import com.ctg.flagadmin.service.PlaceService;
import com.ctg.flagadmin.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {
    private CouncilService councilService;
    private PlaceService placeService;

    @Autowired
    public PlaceController(CouncilService councilService, PlaceService placeService) {
        this.councilService = councilService;
        this.placeService = placeService;
    }

    /**
     * 上传会务室场地
     */
    @PostMapping(value = "/council")
    public ResponseDto postCouncil(Place place, HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute(JWTUtil.USER_ID_KEY);
        Integer role = (Integer) request.getAttribute(JWTUtil.USER_ROLE_KEY);

        place.setKind(PlaceKindEnum.CONFERENCE_ROOM.getValue());
        place.setCount(0);
        place.setAdminKind(role);
        place.setAid(userId);

        councilService.save(place);

        return ResponseDto.succeed();
    }
}
