package com.gengyu.classicalfun.repository;

import com.gengyu.classicalfun.entity.MusicPieceSimple;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MusicPieceSimpleRepository extends JpaRepository <MusicPieceSimple, Integer>{

    @Override
    Optional<MusicPieceSimple> findById(Integer integer);
}
