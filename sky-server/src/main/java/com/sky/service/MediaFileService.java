package com.sky.service;

import com.sky.result.Result;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @description 媒资文件管理业务类
 * @author Mr.M
 * @date 2022/9/10 8:55
 * @version 1.0
 */
public interface MediaFileService {
 /**
  * 从minio下载文件
  * @param bucket 桶
  * @param objectName 对象名称
  * @return 下载后的文件
  */
 public File downloadFileFromMinIO(String bucket, String objectName);

 /**
  * @description 合并分块
  * @param fileMd5  文件md5
  * @param chunkTotal 分块总和
  */
 public Result mergechunks(String fileMd5,int chunkTotal);

 /**
  * 文件上传
  *
  * @param file 文件
  * @return 文件访问路径
  */
 String upload(MultipartFile file);
 /**
  * @description 检查文件是否存在
  * @param fileMd5 文件的md5
  * @return com.xuecheng.base.model.RestResponse<java.lang.Boolean> false不存在，true存在
  */
 public Result<Boolean> checkFile(String fileMd5);
 /**
  * @description 检查分块是否存在
  * @param fileMd5  文件的md5
  * @param chunkIndex  分块序号
  */
 public Result<Boolean> checkChunk(String fileMd5, int chunkIndex);

 /**
  * @description 上传分块
  * @param fileMd5  文件md5
  * @param chunk  分块序号
  * @param localChunkFilePath  分块文件本地路径

  */
 public Result uploadChunk(String fileMd5,int chunk,String localChunkFilePath);

}
