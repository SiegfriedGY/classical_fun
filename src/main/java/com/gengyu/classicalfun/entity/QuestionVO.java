package com.gengyu.classicalfun.entity;

import lombok.Data;
import java.util.Map;

@Data
public class QuestionVO {

    private String composer_period;
    private Map<String, Integer> composer_nation;
    private Map<String, Integer> composer_name;
    private Map<String, Integer> piece_genre;
    private Map<String, Integer> piece_name;
    private Map<String, Integer> movement_num;
    private String file_id;
    private Integer difficulty;
}
