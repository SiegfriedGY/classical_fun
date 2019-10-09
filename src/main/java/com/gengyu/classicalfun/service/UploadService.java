package com.gengyu.classicalfun.service;

import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.repository.MusicPieceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UploadService {

    @Autowired
    private MusicPieceRepository musicPieceRepository;

    public void savePiece(MusicPiece piece){

        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        log.info("生成的UUID为:{}", uuid);
        piece.setUuid(uuid);

        MusicPiece musicPiece = musicPieceRepository.save(piece);
        log.info("已经入库");
    }
}
