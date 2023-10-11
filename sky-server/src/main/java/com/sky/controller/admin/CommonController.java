package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;

import com.sky.service.MediaFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    @Autowired
    private MediaFileService mediaFileService;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传：{}", file);


            //文件的请求路径
            String filePath = mediaFileService.upload(file);
            if (filePath==null){
                log.error("文件上传失败：{}",file);

                return Result.error(MessageConstant.UPLOAD_FAILED);
        }
        return Result.success(filePath);
        }

}