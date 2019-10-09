package com.gengyu.classicalfun.service;

import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.entity.MusicPieceReal;
import com.gengyu.classicalfun.repository.MusicPieceRealRepository;
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

    @Autowired
    private MusicPieceRealRepository realRepository;

    public void savePiece(MusicPiece piece){

        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        log.info("生成的UUID为:{}", uuid);
        piece.setUuid(uuid);

        MusicPiece musicPiece = musicPieceRepository.save(piece);
        log.info("已经入库");
    }

    public void savePieceReal(MusicPieceReal realPiece){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        log.info("生成的UUID为:{}", uuid);
        realPiece.setUuid(uuid);

        MusicPieceReal pieceReal = realRepository.save(realPiece);
        if (null != pieceReal){
            log.info("已经入库！");
        } else {
            log.info("未能入库！");
        }
    }
}
