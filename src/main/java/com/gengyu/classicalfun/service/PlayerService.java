package com.gengyu.classicalfun.service;

import com.gengyu.classicalfun.repository.FileRepository;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private FileRepository fileRepository;

    public void playTest(){
        String path = "D:"+File.separator+"temp"+ File.separator+"123.mp3";
        playMp3(path);
    }

    public void playFile(String fileId){
        String filePath = fileRepository.queryFilePathByFileId(fileId);
        log.info("取到的filePath为：{}",filePath);
        playMp3(filePath);
    }

    private void playMp3(String filePath){

        File file=new File(filePath);
        if(!file.exists()){
            log.info("文件不存在！");
            return;
        }
        log.info("文件存在，现在播放！");
        FileInputStream fis= null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedInputStream stream=new BufferedInputStream(fis);
        Player player= null;
        try {
            player = new Player(stream);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }



}
