package com.ycjh.file.controller;

import com.ycjh.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("file")
public class FileController {


    @Autowired
    FileService fileService;

    @GetMapping("")
    public List<String> index(){
        return fileService.getFileList("/");
    }

}
