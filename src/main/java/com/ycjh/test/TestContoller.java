package com.ycjh.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/test")
public class TestContoller {


    @GetMapping("/html")
    public String html(){
        return "html";
    }

}
