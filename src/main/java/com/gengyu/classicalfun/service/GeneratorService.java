package com.gengyu.classicalfun.service;

import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.entity.MusicPieceReal;
import com.gengyu.classicalfun.repository.MusicPieceRealRepository;
import com.gengyu.classicalfun.repository.MusicPieceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GeneratorService {

    @Autowired
    private MusicPieceRepository musicPieceRepository;

    @Autowired
    private MusicPieceRealRepository realRepository;

    /**
     * 随机抽取piece（简易版）
     * @return
     */
    public MusicPiece generatePieceRandomly(){

        Random random = new Random();

        // 先读取表中数据的数量
        List<MusicPiece> pieces = musicPieceRepository.findAll();
        if (CollectionUtils.isEmpty(pieces)){
            log.info("现在的记录为空！");
            return new MusicPiece();
        }
        List<Integer> piecesIds = pieces.stream().map(e -> e.getId()).collect(Collectors.toList());
        int pieceNum = piecesIds.size();
        int index = random.nextInt(pieceNum);
        log.info("目前记录总数为：{}", pieceNum);
        Integer id = 1;
        if (pieceNum != 0) {
            id = piecesIds.get(index);
            log.info("本次选出的id为：{}", id);
        }

        // 在数量范围内随机抽取
        Optional<MusicPiece> piece = musicPieceRepository.findById(id);
        return piece.get();
    }


    /**
     * 随机抽取一道题目（标准版）
     * @return
     */
    public MusicPieceReal generatePieceRandomlyReal(){

        Random random = new Random();

        // 先读取表中数据的数量
        List<MusicPieceReal> pieces = realRepository.findAll();
        if (CollectionUtils.isEmpty(pieces)){
            log.info("现在的记录为空！");
            return new MusicPieceReal();
        }
        List<Integer> piecesIds = pieces.stream().map(e -> e.getId()).collect(Collectors.toList());
        int pieceNum = piecesIds.size();
        int index = random.nextInt(pieceNum);
        log.info("目前记录总数为：{}", pieceNum);
        Integer id = 1;
        if (pieceNum != 0) {
            id = piecesIds.get(index);
            log.info("本次选出的id为：{}", id);
        }

        // 在数量范围内随机抽取
        Optional<MusicPieceReal> piece = realRepository.findById(id);
        return piece.get();
    }


}
