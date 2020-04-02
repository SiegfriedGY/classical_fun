package com.gengyu.classicalfun.service;

import com.gengyu.classicalfun.entity.MusicPieceSimple;
import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.entity.QuestionVO;
import com.gengyu.classicalfun.repository.MusicPieceRepository;
import com.gengyu.classicalfun.repository.MusicPieceSimpleRepository;
import com.gengyu.classicalfun.utils.ObjectUtil;
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
    private MusicPieceSimpleRepository musicPieceSimpleRepository;

    @Autowired
    private MusicPieceRepository pieceRepository;

    @Autowired
    private BeanService beanService;
    /**
     * 随机抽取piece（简易版）
     * @return
     */
    public MusicPieceSimple generateSimplePiece(){

        Random random = new Random();

        // 先读取表中数据的数量
        List<MusicPieceSimple> pieces = musicPieceSimpleRepository.findAll();
        if (CollectionUtils.isEmpty(pieces)){
            log.info("现在的记录为空！");
            return new MusicPieceSimple();
        }
        MusicPieceSimple pieceSimple = ObjectUtil.selectRandomElement(pieces);
        return pieceSimple;
    }


    /**
     * 随机抽取一道题目（标准版）
     * @return
     */
    public QuestionVO generateSinglePiece(){

        // 先读取表中数据的数量
        List<MusicPiece> pieces = pieceRepository.findAll();
        if (CollectionUtils.isEmpty(pieces)){
            log.info("现在的记录为空！");
            return new QuestionVO();
        }

        MusicPiece piece = ObjectUtil.selectRandomElement(pieces);

        // 转换为QuestionVO
        QuestionVO questionVO = new QuestionVO();
        // 【！！！】很奇怪，如果在service包里，@Service一个类，就可以，
        // 但如果在另一个包里，另一个类里，JPA的方法就会报空指针，不管给这个类注解@Service还是@Component
        // 原因是：方法所在的类也必须使用@Autowired方式注入进来，而不能直接new一个对象来调用，也不能用静态方式调用！！！
        beanService.convertPieceToQuestionVO(piece, questionVO);

        return questionVO;
    }


}
