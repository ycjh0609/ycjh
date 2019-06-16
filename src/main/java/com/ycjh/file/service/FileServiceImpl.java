package com.ycjh.file.service;

import com.ycjh.file.model.FileModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("fileService")
public class FileServiceImpl implements FileService {





    @Override
    public List<FileModel> getFileList(String filePath) {

        File dirFile = new File(filePath);
        File[] fileList = dirFile.listFiles();

        List<FileModel> fileModelList = new ArrayList<>();
        FileModel fileModel;
        for (File tempFile : fileList) {
            fileModel = new FileModel();
            fileModel.setFilePath(filePath);
            fileModel.setFileName(tempFile.getName());

            if (tempFile.isDirectory()){
                fileModel.setType("dir");
            }else{
                fileModel.setType("file");
            }

            fileModelList.add(fileModel);
        }

        Collections.sort(fileModelList);

        return fileModelList;
    }

    @Override
    public boolean uploadFile(MultipartFile multipartFile, String filePath) {
        boolean result = false;

        File file = new File(filePath+multipartFile.getOriginalFilename());
        try{

            //to- do
            //is dir


            //is file

            // etc


            multipartFile.transferTo(file);
            result=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getFilePath() {
        return null;
    }
}
