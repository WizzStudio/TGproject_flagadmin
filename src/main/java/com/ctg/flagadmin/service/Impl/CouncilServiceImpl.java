package com.ctg.flagadmin.service.Impl;

import com.ctg.flagadmin.dao.CouncilDao;
import com.ctg.flagadmin.pojo.entity.Place;
import com.ctg.flagadmin.service.CouncilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouncilServiceImpl implements CouncilService {
    private CouncilDao councilDao;

    @Autowired
    public CouncilServiceImpl(CouncilDao councilDao) {
        this.councilDao = councilDao;
    }

    @Override
    public Place getById(Integer id) {
        return councilDao.getById(id);
    }

    @Override
    public void save(Place place) {
        councilDao.save(place);
    }
}
