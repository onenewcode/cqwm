package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.MediaFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Api(value = "大文件上传接口", tags = "大文件上传接口")
@RestController
public class BigFilesController {

    @Autowired
    MediaFileService mediaFileService;


    @ApiOperation(value = "文件上传前检查文件")
    @PostMapping("/upload/checkfile")
    public Result<Boolean> checkfile(
            @RequestParam("fileMd5") String fileMd5
    ) throws Exception {
        Result<Boolean> booleanRestResponse = mediaFileService.checkFile(fileMd5);
        return booleanRestResponse;
    }


    @ApiOperation(value = "分块文件上传前的检测")
    @PostMapping("/upload/checkchunk")
    public Result<Boolean> checkchunk(@RequestParam("fileMd5") String fileMd5,
                                            @RequestParam("chunk") int chunk) throws Exception {
        Result<Boolean> booleanRestResponse = mediaFileService.checkChunk(fileMd5,chunk);
        return booleanRestResponse;
    }

    @ApiOperation(value = "上传分块文件")
    @PostMapping("/upload/uploadchunk")
    public Result uploadchunk(@RequestParam("file") MultipartFile file,
                                    @RequestParam("fileMd5") String fileMd5,
                                    @RequestParam("chunk") int chunk) throws Exception {

        //创建一个临时文件
        File tempFile = File.createTempFile("minio", ".temp");
        file.transferTo(tempFile);
        //文件路径
        String localFilePath = tempFile.getAbsolutePath();

        Result restResponse = mediaFileService.uploadChunk(fileMd5, chunk, localFilePath);

        return restResponse;
    }
//
//    @ApiOperation(value = "合并文件")
//    @PostMapping("/upload/mergechunks")
//    public Result mergechunks(@RequestParam("fileMd5") String fileMd5,
//                                    @RequestParam("fileName") String fileName,
//                                    @RequestParam("chunkTotal") int chunkTotal) throws Exception {
//        Long companyId = 1232141425L;
//        //文件信息对象
//        UploadFileParamsDto uploadFileParamsDto = new UploadFileParamsDto();
//        uploadFileParamsDto.setFilename(fileName);
//        uploadFileParamsDto.setTags("视频文件");
//        uploadFileParamsDto.setFileType("001002");
//        RestResponse restResponse = mediaFileService.mergechunks(1232141425L, fileMd5, chunkTotal, uploadFileParamsDto);
//        return restResponse;
//    }


}