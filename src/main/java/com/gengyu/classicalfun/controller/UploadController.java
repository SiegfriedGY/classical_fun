package com.gengyu.classicalfun.controller;

import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.entity.ResponseResult;
import com.gengyu.classicalfun.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/01")
    public void saveMusicPiece(@RequestBody MusicPiece musicPiece){
        uploadService.savePiece(musicPiece);
    }


}
