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
    private Integer composer_period;
    private Integer composer_nation;
    private Integer composer_name;
    private Integer piece_genre;
    private String piece_name;
    private Integer movement_num;
    private String file_path;


}
