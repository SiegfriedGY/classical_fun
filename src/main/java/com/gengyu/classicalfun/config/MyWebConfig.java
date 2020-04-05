package com.gengyu.classicalfun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 如果在页面的<audio>标签的src属性里直接写本地资源路径，会报错，不允许直接访问本地资源。
 * 所以必须使用此配置类，进行资源映射。
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    private FileConfig fileConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String fileDir = fileConfig.getFileDir();
        registry.addResourceHandler("/audio/**").addResourceLocations("file:".concat(fileDir));
    }
}
