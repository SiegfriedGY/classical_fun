package com.gengyu.classicalfun.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name="piece_file")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class PieceFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fileId;
    private String fileName;
    private String filePath;

}
