package com.gengyu.classicalfun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getDateStr(){
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
}
