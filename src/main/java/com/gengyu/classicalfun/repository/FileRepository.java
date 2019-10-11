package com.gengyu.classicalfun.repository;

import com.gengyu.classicalfun.entity.PieceFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FileRepository extends JpaRepository<PieceFile, Integer>{

    @Query(value = "select from ", nativeQuery = true)
    String queryFilePathByFileId(Integer fileId);

}
