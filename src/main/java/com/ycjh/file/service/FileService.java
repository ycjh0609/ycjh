package com.ycjh.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    public List<String> getFileList(String path);

    public boolean uploadFile(MultipartFile multipartFile, String path);

    public String getFilePath();


}
