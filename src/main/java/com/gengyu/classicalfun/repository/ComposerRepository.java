package com.gengyu.classicalfun.repository;

import com.gengyu.classicalfun.dict.Composer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ComposerRepository extends JpaRepository<Composer, Integer>{

    @Query(value="select c.name_CN from dict_composer c where c.id =?1", nativeQuery = true)
    String queryNameZHById(Integer id);
}
