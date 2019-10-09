package com.gengyu.classicalfun.controller;

import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.entity.MusicPieceReal;
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

    @GetMapping("/01")
    public ResponseResult<MusicPiece> generateGenerally(){

        MusicPiece musicPiece = generatorService.generatePieceRandomly();

        ResponseResult<MusicPiece> responseResult = new ResponseResult<>();
        responseResult.setCode(1).setMsg("success").setData(musicPiece);
        return responseResult;
    }

    @GetMapping("/02")
    public ResponseResult<MusicPieceReal> generateGenerallyReal(){

        MusicPieceReal musicPieceReal = generatorService.generatePieceRandomlyReal();

        ResponseResult<MusicPieceReal> responseResult = new ResponseResult<>();
        responseResult.setCode(1).setMsg("success").setData(musicPieceReal);
        return responseResult;
    }


}
