package com.ycjh.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserContollerTest {

    @Test
    public void filelist() {
        List<String> ls;

        String path="/Users/daniel/Projects/ycjh";
        File dirFile=new File(path);
        File []fileList=dirFile.listFiles();

        for(File tempFile : fileList) {
            if(tempFile.isFile()) {
                String tempPath=tempFile.getParent();
                String tempFileName=tempFile.getName();
                System.out.println("Path="+tempPath);
                System.out.println("FileName="+tempFileName);
                /*** Do something withd tempPath and temp FileName ^^; ***/
            }
        }

    }
}
