package com.gengyu.classicalfun.service;

import com.gengyu.classicalfun.entity.MusicPieceSimple;
import com.gengyu.classicalfun.entity.MusicPiece;
import com.gengyu.classicalfun.entity.PieceFile;
import com.gengyu.classicalfun.repository.MusicPieceRepository;
import com.gengyu.classicalfun.repository.MusicPieceSimpleRepository;
import com.gengyu.classicalfun.repository.PieceFileRepository;
import com.gengyu.classicalfun.utils.DateUtil;
import com.gengyu.classicalfun.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class UploadService {

    public static String ROOT_PATH = "";

    static{
//        String path1 = "";
//        try {
//            path1 = ResourceUtils.getURL("classpath:").getPath();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        log.info("得到的项目路径2为:{}", path1);
//        rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//      //得到的项目路径1为:/D:/codes/msgnotification/target/classes/
        ROOT_PATH = System.getProperty("user.dir");  /// 得到的项目路径1为:D:\codes\msgnotification
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>得到的项目路径为:{}", ROOT_PATH);
        /// 项目打成jar包运行后，这个路径为jar包所在目录，即target。
    }

    @Autowired
    private MusicPieceSimpleRepository musicPieceSimpleRepository;

    @Autowired
    private MusicPieceRepository realRepository;

    @Autowired
    private PieceFileRepository pieceFileRepository;

    public void savePiece(MusicPieceSimple piece){

        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        log.info("生成的UUID为:{}", uuid);
        piece.setUuid(uuid);

        MusicPieceSimple musicPieceSimple = musicPieceSimpleRepository.save(piece);
        log.info("已经入库");
    }

    public void savePieceReal(MusicPiece realPiece){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        log.info("生成的UUID为:{}", uuid);
        realPiece.setUuid(uuid);

        MusicPiece pieceReal = realRepository.save(realPiece);
        if (null != pieceReal){
            log.info("已经入库！");
        } else {
            log.info("未能入库！");
        }
    }


    public String uploadSingleFile(MultipartFile file){

        String fileNameSaved = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        String localFilePath = ROOT_PATH + File.separator +"upload" + File.separator + DateUtil.getDateStr();
        log.info("创建/找到的本地上传目录为：{}",localFilePath);

        File localFile = new File(localFilePath);
        if (!localFile.exists()){
            log.info("目录不存在，现在创建！");
            localFile.mkdirs();
        }

        String localFilePathName = localFilePath + File.separator + fileNameSaved;
        File destLocal = new File(localFilePathName);
        log.info("上传目的地为：{}", destLocal);

        try {
            file.transferTo(destLocal); /// 上传
        } catch (IOException e) {
            e.printStackTrace();
            log.info(e.toString(), e);
            return "上传失败！";
        }

        /// 上传成功后，将数据入库，返回唯一识别标识fileId
        return this.saveUploadFile(fileNameSaved, localFilePathName);
    }

    private String saveUploadFile(String fileNameSaved, String filePathName){

        PieceFile pieceFile = new PieceFile();

        /// 构建每个文件的唯一标识id,规则是：当前系统时间戳_随机生成5位字符串
        String fileId = System.currentTimeMillis() + "_" + StringUtil.generateSingleStr(5);

        pieceFile.setFileId(fileId)
                .setFileName(fileNameSaved)
                .setFilePath(filePathName);

        pieceFileRepository.save(pieceFile);
        log.info("构建好的PieceFile对象为:{}，已将其保存入库！", pieceFile);

        return fileId;
    }














}
