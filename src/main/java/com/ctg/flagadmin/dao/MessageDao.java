package com.ctg.flagadmin.dao;

import com.ctg.flagadmin.pojo.entity.Message;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer> {
    String updateAllStateByKind = "UPDATE message " +
            "SET state = :state " +
            "WHERE kind = :kind";

    Message getById(Integer id);

    Message getByKindAndState(Integer kind, Integer value);

    @Modifying
    @Transactional
    @Query(value = updateAllStateByKind, nativeQuery = true)
    int updateAllStateByKind(@Param("kind") Integer kind, @Param("state") Integer state);
}
