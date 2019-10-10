package com.gengyu.classicalfun.repository;

import com.gengyu.classicalfun.dict.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PeriodRepository extends JpaRepository<Period, Integer> {

    @Query(value = "SELECT p.period_name FROM dict_period p WHERE p.period_number=?1", nativeQuery = true)
    String queryPeriodNameByPeriodNumber(Integer period_number);

}
