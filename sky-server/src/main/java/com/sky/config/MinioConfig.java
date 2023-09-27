package com.sky.config;


import com.sky.properties.MinioProperties;

import com.sky.utils.MinioUtil;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于创建AliOssUtil对象
 */
@Configuration
@Slf4j
public class MinioConfig {

    @Bean
    @ConditionalOnMissingBean //它是修饰bean的一个注解，主要实现的是，当你的bean被注册之后，如果而注册相同类型的bean，就不会成功，它会保证你的bean只有一个，即你的实例只有一个。
    public MinioUtil MivioUtil(MinioProperties minioProperties){
        log.info("开始创建minio服务器：{}",minioProperties);
        return new MinioUtil(
                minioProperties.getEndpoint(),
                minioProperties.getBucketName(),
                MinioClient.builder()
                        .endpoint(minioProperties.getEndpoint())
                        .credentials(minioProperties.getAccessKeyId(), minioProperties.getAccessKeySecret())
                        .build());
    }
}