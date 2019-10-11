package com.gengyu.classicalfun.repository;

import com.gengyu.classicalfun.entity.PieceFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FileRepository extends JpaRepository<PieceFile, Integer>{

    @Query(value = "select f.file_path from piece_file f where f.file_id=?1", nativeQuery = true)
    String queryFilePathByFileId(String fileId);

}
