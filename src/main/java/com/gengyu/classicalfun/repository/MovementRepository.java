package com.gengyu.classicalfun.repository;

import com.gengyu.classicalfun.dict.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovementRepository extends JpaRepository<Movement, Integer>{

    @Query(value = "select m.movement_code from dict_movement m where m.movement_number=?1",
            nativeQuery = true)
    String queryMvtCodeByMvtNumber(Integer number);
}
