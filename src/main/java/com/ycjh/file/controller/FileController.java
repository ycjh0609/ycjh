package com.ycjh.file.controller;

import com.ycjh.file.config.FilePropertiesConfig;
import com.ycjh.file.model.FileModel;
import com.ycjh.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    FileService fileService;

    @Autowired
    FilePropertiesConfig filePropertiesConfig;

    @GetMapping("")
    public List<FileModel> index() {
        String filePath = filePropertiesConfig.getBaseDir();

        return fileService.getFileList(filePath);
    }
    @PutMapping(value="/upload")
    public String upload(@RequestParam("file")MultipartFile file){


        String filePath = filePropertiesConfig.getBaseDir();


        return "" + fileService.uploadFile(file, filePath);
    }

}
