package com.gengyu.classicalfun.service;

import com.gengyu.classicalfun.dict.Nation;
import com.gengyu.classicalfun.dict.Period;
import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.entity.QuestionVO;
import com.gengyu.classicalfun.repository.ComposerRepository;
import com.gengyu.classicalfun.repository.NationRepository;
import com.gengyu.classicalfun.repository.PeriodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class BeanService {

    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private NationRepository nationRepository;

    @Autowired
    private ComposerRepository composerRepository;

    public void convertPieceToQuestionVO(MusicPiece piece, QuestionVO questionVO){

        // 1.设置periodStr
        String periodStr = periodRepository.queryPeriodNameByPeriodNumber(piece.getComposer_period());
        questionVO.setComposer_period(periodStr);

        // 2.设置nation
        Map<String, Integer> nationMap = new HashMap<String, Integer>();

        Integer nationReal = piece.getComposer_nation();
        System.out.println("=====================取出的nationReal值为："+nationReal);
        String nationRealStr = nationRepository.findById(nationReal).get().getName();
        System.out.println("=====================对应的nation为："+nationRealStr);
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
        Map<String, Integer> composerMap = new HashMap<String, Integer>();
        String composerReal = composerRepository.queryNameZHById(piece.getComposer());
        composerMap.put(composerReal,1);
        composerMap.put("张三",0);
        composerMap.put("李四",0);
        composerMap.put("王五",0);
        questionVO.setComposer_name(composerMap);

    }
}
