package com.ycjh.file.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceImplTest {

    //@Resource(name="fileService")
    @Autowired
    FileService fileService;

    @Test
    public void test() {
        System.out.println(fileService.getFileList("/User/daniel/projects/ycjh").toString());

    }



}
