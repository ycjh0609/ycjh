package com.ycjh.file.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service("fileService")
public class FileServiceImpl implements FileService {
    @Override
    public List<String> getFileList(String path) {

        File dirFile = new File(path);
        File[] fileList = dirFile.listFiles();

        List<String> fileNameList = new ArrayList<>();
        for (File tempFile : fileList) {
            fileNameList.add(tempFile.getName());
        }
        fileNameList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
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
