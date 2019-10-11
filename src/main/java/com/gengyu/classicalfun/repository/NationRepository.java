package com.gengyu.classicalfun.repository;

import com.gengyu.classicalfun.dict.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface NationRepository extends JpaRepository<Nation, Integer>{
}
