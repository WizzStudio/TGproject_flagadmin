package com.ctg.flagadmin.service.Impl;

import com.ctg.flagadmin.dao.PlaceDao;
import com.ctg.flagadmin.dao.PlaceOrderDao;
import com.ctg.flagadmin.dao.UserDao;
import com.ctg.flagadmin.pojo.dto.PlaceOrderDetailDto;
import com.ctg.flagadmin.pojo.dto.PlaceOrderListItemDto;
import com.ctg.flagadmin.pojo.entity.Place;
import com.ctg.flagadmin.pojo.entity.PlaceOrder;
import com.ctg.flagadmin.pojo.entity.User;
import com.ctg.flagadmin.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {
    private final PlaceOrderDao placeOrderDao;
    private final UserDao userDao;
    private final PlaceDao placeDao;

    @Autowired
    public PlaceOrderServiceImpl(PlaceOrderDao placeOrderDao, UserDao userDao, PlaceDao placeDao) {
        this.placeOrderDao = placeOrderDao;
        this.userDao = userDao;
        this.placeDao = placeDao;
    }

    @Override
    public PlaceOrderDetailDto getPlaceOrderDetailById(Integer oid) {
        PlaceOrder placeOrder = placeOrderDao.getById(oid);
        if (placeOrder == null) {
            return null;
        }
        User user = userDao.getById(placeOrder.getUid());
        Place place = placeDao.getById(placeOrder.getPid());
        PlaceOrderDetailDto placeOrderDetailDto = new PlaceOrderDetailDto();

        placeOrderDetailDto.setUsername(user.getName());
        placeOrderDetailDto.setPlaceName(place.getName());
        placeOrderDetailDto.setActivity(placeOrder.getActivity());
        placeOrderDetailDto.setContent(placeOrder.getContent());
        placeOrderDetailDto.setDepartment(placeOrder.getDepartment());
        placeOrderDetailDto.setStartTime(placeOrder.getStartTime());
        placeOrderDetailDto.setEndTime(placeOrder.getEndTime());
        placeOrderDetailDto.setFeedback(placeOrder.getFeedback());
        placeOrderDetailDto.setOrderId(placeOrder.getId());
        placeOrderDetailDto.setAdmin(placeOrder.getAdmin());
        placeOrderDetailDto.setPhone(placeOrder.getPhone());
        placeOrderDetailDto.setPeople(placeOrder.getPeople());
        placeOrderDetailDto.setProp(placeOrder.getProp());
        placeOrderDetailDto.setStatus(placeOrder.getState());

        return placeOrderDetailDto;
    }

    @Override
    public List<PlaceOrderListItemDto> findAllByStateAndAdminKind(Integer state, Integer adminKind) {
        List<Place> places = placeDao.findAllByAdminKind(adminKind);
        List<Integer> pids = new ArrayList<>();
        for (Place place : places) {
            pids.add(place.getId());
        }
        List<PlaceOrder> orders = placeOrderDao.findAllByStateAndPidIn(state, pids);
        orders.sort(Comparator.comparing(PlaceOrder::getStartTime));

        places.sort(Comparator.comparing(Place::getId));
        Place[] array = (Place[]) places.toArray();
        List<PlaceOrderListItemDto> items = new ArrayList<>();
        for (PlaceOrder placeOrder: orders) {
            items.add(new PlaceOrderListItemDto(
                    getPlaceName(array, placeOrder.getPid()),
                    placeOrder.getDepartment(),
                    placeOrder.getId()));
        }

        return items;
    }

    /**
     * 从已知列表中，通过二分查找，获得指定id的名称
     */
    private String getPlaceName(Place[] places, Integer pid) {
        Place place = new Place();
        place.setId(pid);
        int i = Arrays.binarySearch(places, place, Comparator.comparing(Place::getId));
        return places[i].getName();
    }
}
