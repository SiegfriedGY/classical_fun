package com.gengyu.classicalfun.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Random;

@Slf4j
public class ObjectUtil<T> {

    public static<T> T selectRandomElement(List<T> fullList){
        if (CollectionUtils.isEmpty(fullList)){
            log.info("fullList is null");
            return null;
        }
        Random random = new Random();
        int size = fullList.size();
        log.info("目前记录总数为：{}", size);
        return fullList.get(random.nextInt(size));
    }

}
