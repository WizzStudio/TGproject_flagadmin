package com.ctg.flagadmin.service.Impl;

import com.ctg.flagadmin.dao.CouncilOrderDao;
import com.ctg.flagadmin.enums.AdminKindEnum;
import com.ctg.flagadmin.enums.CouncilStateEnum;
import com.ctg.flagadmin.pojo.dto.CouncilOrderDetailDto;
import com.ctg.flagadmin.pojo.dto.CouncilOrderListDto;
import com.ctg.flagadmin.pojo.dto.CouncilOrderListDtoComponent.ListCompletedTimeDto;
import com.ctg.flagadmin.pojo.dto.CouncilOrderListDtoComponent.ListOrderItemDto;
import com.ctg.flagadmin.pojo.entity.CouncilOrder;
import com.ctg.flagadmin.pojo.entity.Place;
import com.ctg.flagadmin.service.CouncilOrderService;
import com.ctg.flagadmin.service.CouncilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CouncilOrderServiceImpl implements CouncilOrderService{
    private CouncilOrderDao councilOrderDao;
    private CouncilService councilService;

    @Autowired
    public CouncilOrderServiceImpl(CouncilOrderDao councilOrderDao, CouncilService councilService) {
        this.councilOrderDao = councilOrderDao;
        this.councilService = councilService;
    }

    @Override
    public CouncilOrder getById(Integer oid) {
        return councilOrderDao.getById(oid);
    }

    @Override
    public CouncilOrderDetailDto getDetailById(Integer oid) {
        CouncilOrder co =  councilOrderDao.getById(oid);
        if (co == null)
            return null;
        Place council = councilService.getById(co.getCid());
        CouncilOrderDetailDto codd = new CouncilOrderDetailDto(co);
        codd.setCouncilName(council.getName());
        return codd;
    }



    @Override
    public List<CouncilOrderListDto> listPendingOrderByRole(Integer cid, Integer role) {
        List<Integer> states = new ArrayList<>();
        states.add(CouncilStateEnum.PENDING.getValue());
        states.add(CouncilStateEnum.SECOND_NOT_SURE.getValue());
        states.add(CouncilStateEnum.SECOND_ACCEPT.getValue());
        states.add(CouncilStateEnum.FIRST_ACCEPT.getValue());
        List<CouncilOrder> cos = councilOrderDao.findAllByCidAndStateInAndStartTimeGreaterThanOrderByStartTime(
                cid, states, getTimeMorning());

        List<CouncilOrderListDto> colds = new ArrayList<>();
        List<ListOrderItemDto> loids = new ArrayList<>();
        List<ListCompletedTimeDto> lctds = new ArrayList<>();
        Date date = new Date();
        for (CouncilOrder co: cos) {
            // 新的一天，保存上一天数据，开始下一天
            if (!getDay(date).equals(getDay(co.getStartTime()))) {
                if(loids.size() > 0) {
                    CouncilOrderListDto cold = new CouncilOrderListDto();

                    // 二级不确定的优先显示
                    loids.sort((l1, l2) -> {
                        int st = l1.getState().compareTo(l2.getState());
                        if (st != 0) {
                            return -1*st;
                        } else {
                            return -1*l1.getStartTime().compareTo(l2.getStartTime());
                        }
                    });

                    // 完成的，按照时间排序
                    lctds.sort(Comparator.comparing(ListCompletedTimeDto::getStartTime));

                    cold.setCompletedTime(lctds);
                    cold.setOrderItem(loids);
                    cold.setDate(getDate(loids.get(0).getStartTime()));
                    colds.add(cold);
                }
                date = co.getStartTime();
                loids = new ArrayList<>();
                lctds = new ArrayList<>();
            }
            // 正在申请的信息,一级包括二级不确定和正在审核， 二级只有正在审核
            if (co.getState().equals(CouncilStateEnum.PENDING.getValue()) ||
                    (role.equals(AdminKindEnum.FIRST_COUNCIL_ADMIN.getValue()) &&
                    co.getState().equals(CouncilStateEnum.SECOND_NOT_SURE.getValue()))) {
                ListOrderItemDto loid = new ListOrderItemDto();
                loid.setId(co.getId());
                loid.setState(co.getState());
                loid.setActivityName(co.getActivityName());
                loid.setEndTime(co.getEndTime());
                loid.setStartTime(co.getStartTime());
                loid.setTeamName(co.getTeamName());
                loids.add(loid);
            } else if (!co.getState().equals(CouncilStateEnum.SECOND_NOT_SURE.getValue())){
                // 完成的时间段，都是一二级通过的
                ListCompletedTimeDto lctd = new ListCompletedTimeDto();
                lctd.setEndTime(co.getEndTime());
                lctd.setStartTime(co.getStartTime());
                lctds.add(lctd);
            }
        }

        if(loids.size() > 0) {
            CouncilOrderListDto cold = new CouncilOrderListDto();
            cold.setCompletedTime(lctds);
            cold.setOrderItem(loids);
            cold.setDate(getDate(date));
            colds.add(cold);
        }
        return colds;
    }

    @Override
    public List<Map<String, Object>> listCompletedOrderByRole(Integer role) {
        List<Integer> states = new ArrayList<>();
        states.add(CouncilStateEnum.FIRST_ACCEPT.getValue());
        states.add(CouncilStateEnum.SECOND_ACCEPT.getValue());
        states.add(CouncilStateEnum.FIRST_REFUSED.getValue());
        states.add(CouncilStateEnum.SECOND_REFUSED.getValue());
        if (role.equals(AdminKindEnum.SECOND_COUNCIL_ADMIN.getValue())) {
            states.add(CouncilStateEnum.SECOND_NOT_SURE.getValue());
        }
        List<CouncilOrder> cos = councilOrderDao.findAllByStateInOrderByUpdateTimeDesc(states);
        List<Map<String, Object>> ccos = new ArrayList<>();

        cos.forEach(co -> {
            Map<String, Object> cco = new HashMap<>();
            cco.put("oid", co.getId());
            cco.put("teamName", co.getTeamName());
            cco.put("createTime", co.getCreateTime());
            ccos.add(cco);
        });
        return ccos;
    }

    @Override
    public List<Map<String, Object>> listCountByRole(Integer role) {
        List<Integer> states = new ArrayList<>();
        states.add(CouncilStateEnum.PENDING.getValue());
        if (role.equals(AdminKindEnum.FIRST_COUNCIL_ADMIN.getValue())) {
            states.add(CouncilStateEnum.SECOND_NOT_SURE.getValue());
        }
        List<CouncilOrder> cos = councilOrderDao.findAllByStateInOrderByCid(states);

        List<Map<String, Object>> counts = new ArrayList<>();

        Integer curCid = null;
        Integer cnt = 0;
        for (CouncilOrder co : cos) {
            if (curCid == null) {
                curCid = co.getCid();
            }
            if (!curCid.equals(co.getCid())) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", councilService.getById(curCid).getName());
                map.put("count", cnt);
                map.put("id", curCid);
                counts.add(map);

                curCid = co.getCid();
                cnt = 0;
            }
            cnt++;
        }
        if (cnt != 0){
            Map<String, Object> map = new HashMap<>();
            map.put("name", councilService.getById(curCid).getName());
            map.put("count", cnt);
            map.put("id", curCid);
            counts.add(map);
        }
        return counts;
    }

    @Override
    public void checkByRole(Integer oid, String feedback, Integer state, Integer role) {
        // 审核失败
        if (state == 0) {
            if (!role.equals(AdminKindEnum.SECOND_COUNCIL_ADMIN.getValue())) {
                state = CouncilStateEnum.FIRST_REFUSED.getValue();
            } else {
                state = CouncilStateEnum.SECOND_REFUSED.getValue();
            }
        // 审核通过
        } else if (state == 1) {
            if (!role.equals(AdminKindEnum.SECOND_COUNCIL_ADMIN.getValue())) {
                state = CouncilStateEnum.FIRST_ACCEPT.getValue();
            } else {
                state = CouncilStateEnum.SECOND_ACCEPT.getValue();
            }
        // 二级不确定, state == 2
        } else {
            state = CouncilStateEnum.SECOND_NOT_SURE.getValue();
        }

        CouncilOrder councilOrder = councilOrderDao.getById(oid);
        councilOrder.setState(state);
        councilOrder.setFeedback(feedback);

        councilOrderDao.save(councilOrder);
    }

    // 获得当天0点时间
    private Date getTimeMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // 获得日期
    private Date getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTime();
    }

    // 获取当天日期
    private Integer getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        cal.setTimeZone(timeZone);
        return cal.get(Calendar.DATE);
    }
}
