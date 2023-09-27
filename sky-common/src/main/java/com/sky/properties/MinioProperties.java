package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Component;

//@Component //标注一个类为Spring容器的Bean，（把普通pojo实例化到spring容器中
// @Configuration注解标识的类中声明了1个或者多个@Bean方法，Spring容器可以使用这些方法来注入Bean，
@Component
@ConfigurationProperties(prefix = "sky.minio")
@Data
public class MinioProperties {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
