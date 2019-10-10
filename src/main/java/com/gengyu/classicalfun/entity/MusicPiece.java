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
public class MusicPiece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uuid;

    /// 不用混淆项，每次都罗列全部periods
    private Integer composer_period;

    /// 需要提供混淆项
    private Integer composer_nation;
    private Integer composer_nation_fake01;
    private Integer composer_nation_fake02;
    private Integer composer_nation_fake03;
    /// 需要提供混淆项
    private Integer composer;
    private Integer composer_fake01;
    private Integer composer_fake02;
    private Integer composer_fake03;
    /// 需要提供混淆项
    private Integer piece_genre;
    private Integer piece_genre_fake01;
    private Integer piece_genre_fake02;
    private Integer piece_genre_fake03;
    /// 需要提供混淆项
    private String piece_name;
    private String piece_name_fake01;
    private String piece_name_fake02;
    private String piece_name_fake03;

    /// 需要提供混淆项
    private Integer movement_num;
    private Integer movement_num_fake01;
    private Integer movement_num_fake02;
    private Integer movement_num_fake03;

    private String file_id;

    /// 难度级别：1-5增加
    private Integer difficulty;


}
