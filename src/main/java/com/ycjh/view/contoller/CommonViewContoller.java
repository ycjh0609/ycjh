package com.ycjh.view.contoller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/common")
public class CommonViewContoller {

    @GetMapping("/index")
    public String index(){
        return "/common/index";
    }


}
