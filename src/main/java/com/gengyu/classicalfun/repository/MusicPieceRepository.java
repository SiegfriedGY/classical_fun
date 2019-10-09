package com.gengyu.classicalfun.repository;

import com.gengyu.classicalfun.entity.MusicPiece;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MusicPieceRepository extends JpaRepository <MusicPiece, Integer>{

    @Override
    Optional<MusicPiece> findById(Integer integer);
}
