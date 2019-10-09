package com.gengyu.classicalfun.controller;

import com.gengyu.classicalfun.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/play")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/mp3")
    public void playMp3(){

        log.info("现在调用service方法进行播放...");
        playerService.playMp3();
        log.info("播放完毕...");
    }

}
