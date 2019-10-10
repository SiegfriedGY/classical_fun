package com.gengyu.classicalfun.controller;

import com.gengyu.classicalfun.entity.MusicPieceSimple;
import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.entity.QuestionVO;
import com.gengyu.classicalfun.entity.ResponseResult;
import com.gengyu.classicalfun.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gen")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    // Simlple版，非实际
    @GetMapping("/01")
    public ResponseResult<MusicPieceSimple> generateSimplePiece(){

        MusicPieceSimple musicPieceSimple = generatorService.generateSimplePiece();
        ResponseResult<MusicPieceSimple> responseResult = new ResponseResult<>();
        responseResult.setCode(1).setMsg("success").setData(musicPieceSimple);
        return responseResult;
    }

    // 产生一道题
    @GetMapping("/02")
    public ResponseResult<QuestionVO> generatePiece(){

        QuestionVO questionVO = generatorService.generateSinglePiece();
        ResponseResult<QuestionVO> responseResult = new ResponseResult<>();
        responseResult.setCode(1).setMsg("success").setData(questionVO);
        return responseResult;
    }


}
