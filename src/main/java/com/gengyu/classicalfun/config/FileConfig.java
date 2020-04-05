package com.gengyu.classicalfun.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "play")
public class FileConfig {

    private String filePath;
    private String fileDir;

}
