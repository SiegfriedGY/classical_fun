package com.gengyu.classicalfun.utils;

import java.util.Random;

public class StringUtil {
    public static String generateSingleStr(int length){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < length; j++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
