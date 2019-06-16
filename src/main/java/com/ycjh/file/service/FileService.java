package com.ycjh.file.service;

import com.ycjh.file.model.FileModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    public List<FileModel> getFileList(String path);
    public boolean uploadFile(MultipartFile multipartFile, String path);
    public String getFilePath();


}
