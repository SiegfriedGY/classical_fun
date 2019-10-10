package com.gengyu.classicalfun.controller;

import com.gengyu.classicalfun.entity.MusicPieceSimple;
import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    @PostMapping("/test01")
    public String uploadSingle(@RequestParam("attachment") MultipartFile file){

        if (null == file){
            return "上传的附件为空，请选择合适的文件上传！";
        }
        String fileId = uploadService.uploadSingleFile(file);

        log.info("生成的fileId为：{}", fileId);
        return fileId;

    }

    @PostMapping("/01")
    public void saveMusicPiece(@RequestBody MusicPieceSimple musicPieceSimple){
        uploadService.savePiece(musicPieceSimple);
    }

    @PostMapping("/02")
    public void saveMusicPieceReal(@RequestBody MusicPiece realPiece){
        uploadService.savePieceReal(realPiece);
    }


}
