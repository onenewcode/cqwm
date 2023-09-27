package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//定义注解能够添加的位置
@Target(ElementType.METHOD)
//注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
//     操作类型，UPDATE，INSTERT
    OperationType value();
}
