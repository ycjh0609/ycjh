package com.ycjh.common.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CommonContoller {


    @GetMapping("/")
    public String inedx(){
        return "redirect:/login";
    }
}
