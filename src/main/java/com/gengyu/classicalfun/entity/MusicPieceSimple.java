package com.gengyu.classicalfun.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;

@Data
@Slf4j
@Table(name="music_piece")
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class MusicPieceSimple {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uuid;
    private Integer composer_period;

    /// 需要提供混淆项
    private Integer composer_nation;
    /// 需要提供混淆项
    private Integer composer_name;
    /// 需要提供混淆项
    private Integer piece_genre;
    /// 需要提供混淆项
    private String piece_name;
    /// 需要提供混淆项
    private Integer movement_num;

    private String file_id;

    /// 难度级别：1-5递增
    private Integer difficulty;


}
