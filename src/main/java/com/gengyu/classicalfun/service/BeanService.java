package com.gengyu.classicalfun.service;

import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.entity.QuestionVO;
import com.gengyu.classicalfun.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class BeanService {

    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private NationRepository nationRepository;

    @Autowired
    private ComposerRepository composerRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovementRepository movementRepository;

    public void convertPieceToQuestionVO(MusicPiece piece, QuestionVO questionVO){

        // 1.设置periodStr
        String periodStr = periodRepository.queryPeriodNameByPeriodNumber(piece.getComposer_period());
        questionVO.setComposer_period(periodStr);

        // 2.设置nation
        Map<String, Integer> nationMap = new HashMap<>();

        Integer nationReal = piece.getComposer_nation();
        String nationRealStr = nationRepository.findById(nationReal).get().getName();
        Integer nationFake01 = piece.getComposer_nation_fake01();
        String nationFk01 = "FAKE01";
        Integer nationFake02 = piece.getComposer_nation_fake02();
        String nationFk02 = "FAKE02";
        Integer nationFake03 = piece.getComposer_nation_fake03();
        String nationFk03 = "FAKE03";
        nationMap.put(nationFk01, 0);
        nationMap.put(nationFk02, 0);
        nationMap.put(nationRealStr, 1);
        nationMap.put(nationFk03, 0);
        questionVO.setComposer_nation(nationMap);

        // 3.设置composer
        Map<String, Integer> composerMap = new HashMap<>();
        String composerReal = composerRepository.queryNameZHById(piece.getComposer());
        composerMap.put(composerReal,1);
        composerMap.put("张三",0);
        composerMap.put("李四",0);
        composerMap.put("王五",0);
        questionVO.setComposer_name(composerMap);

        // 4.设置genre
        Map<String, Integer> genreMap = new HashMap<>();
        String genreReal = genreRepository.queryGenreNameByGenreNumber(piece.getPiece_genre());
        genreMap.put(genreReal,1);
        genreMap.put("错误Genre01",0);
        genreMap.put("错误Genre02",0);
        genreMap.put("错误Genre03",0);
        questionVO.setPiece_genre(genreMap);

        // 5.设置pieceName
        Map<String, Integer> pieceMap = new HashMap<>();
        pieceMap.put(piece.getPiece_name(),1);
        pieceMap.put(piece.getPiece_name_fake01(),0);
        pieceMap.put(piece.getPiece_name_fake02(),0);
        pieceMap.put(piece.getPiece_name_fake03(),0);
        questionVO.setPiece_name(pieceMap);

        // 6.设置movement
        Map<String, Integer> mvtMap = new HashMap<>();
        String mvtReal = movementRepository.queryMvtCodeByMvtNumber(piece.getMovement_num());
        mvtMap.put(mvtReal,1);
        mvtMap.put("错误movement01",0);
        mvtMap.put("错误movement02",0);
        mvtMap.put("错误movement03",0);
        questionVO.setMovement_num(mvtMap);

        // 7.设置fileId
        questionVO.setFile_id(piece.getFile_id());

        // 8.设置difficulty
        questionVO.setDifficulty(piece.getDifficulty());
    }
}
