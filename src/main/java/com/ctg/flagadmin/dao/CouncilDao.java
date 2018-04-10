package com.ctg.flagadmin.dao;

import com.ctg.flagadmin.pojo.entity.CouncilOrder;
import com.ctg.flagadmin.pojo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouncilDao extends JpaRepository<Place, Integer> {
    Place getById(Integer id);
}
