package com.zb.backstage.core.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @Author: zb
 * @Date: Created in 2018/6/1 10:13
 * @Description: 文件上传限制
 */
@Configuration
public class MultipartConfigurer {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        factory.setMaxFileSize("10MB");
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }
}
