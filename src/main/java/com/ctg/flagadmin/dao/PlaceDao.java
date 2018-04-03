package com.ctg.flagadmin.dao;

import com.ctg.flagadmin.pojo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceDao extends JpaRepository<Place, Integer> {
    Place getById(Integer id);

    List<Place> findAllByAdminKind(Integer adminKind);
}
