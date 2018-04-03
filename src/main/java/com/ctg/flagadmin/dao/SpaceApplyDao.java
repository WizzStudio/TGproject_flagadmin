package com.ctg.flagadmin.dao;

import com.ctg.flagadmin.pojo.entity.SpaceApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface SpaceApplyDao extends JpaRepository<SpaceApply, Integer> {
    SpaceApply getById(Integer id);
    List<SpaceApply> findAllByState(Integer state);

    List<SpaceApply> findAllByStateIn(Collection<Integer> state);
}
