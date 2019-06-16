package com.ycjh.file.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service("fileService")
public class FileServiceImpl implements FileService {
    @Override
    public List<String> getFileList(String path) {

        File dirFile=new File(path);
        File[]fileList=dirFile.listFiles();

        List<String> fileNameList = new ArrayList<>();
        for(File tempFile : fileList) {
            if(tempFile.isFile()) {
                fileNameList.add(tempFile.getName());
            }
        }
        return fileNameList;
    }

    @Override
    public boolean uploadFile(MultipartFile multipartFile, String path) {


        return true;
    }

    @Override
    public String getFilePath() {
        return null;
    }
}
