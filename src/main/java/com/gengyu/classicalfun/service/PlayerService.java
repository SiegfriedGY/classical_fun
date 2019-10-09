package com.gengyu.classicalfun.service;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.stereotype.Service;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class PlayerService {

    public void playMp3(){

        String path = "D:"+File.separator+"temp"+ File.separator+"123.mp3";
        File file=new File(path);
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
