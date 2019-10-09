package com.gengyu.classicalfun.service;

import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.repository.MusicPieceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class GeneratorService {

    @Autowired
    private MusicPieceRepository musicPieceRepository;

    public MusicPiece generatePieceRandomly(){

        Random random = new Random();
        // 先读取表中数据的数量

        Integer id = 1;
        int pieceNum = musicPieceRepository.findAll().size();
        log.info("目前记录总数为：{}", pieceNum);
        if (pieceNum != 0) {
            id = random.nextInt(pieceNum)+1;
            log.info("本次选出的id为：{}", id);
        }

        // 在数量范围内随机抽取
        Optional<MusicPiece> piece = musicPieceRepository.findById(id);
        return piece.get();
    }
}
