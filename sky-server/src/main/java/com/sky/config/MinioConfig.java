package com.sky.config;


import com.sky.properties.MinioProperties;

import io.minio.MinioClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于创建AliOssUtil对象
 */
@Configuration
@Data
@Slf4j
@ConfigurationProperties(prefix = "sky.minio")
public class MinioConfig {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    @Bean
    @ConditionalOnMissingBean //它是修饰bean的一个注解，主要实现的是，当你的bean被注册之后，如果而注册相同类型的bean，就不会成功，它会保证你的bean只有一个，即你的实例只有一个。
    public MinioClient minioClient(){
        log.info("开始创建minio服务器");
        return MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials(accessKeyId, accessKeySecret)
                        .build();
    }
}