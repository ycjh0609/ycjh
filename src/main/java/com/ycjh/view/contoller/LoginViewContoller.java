package com.ycjh.view.contoller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginViewContoller {

    @GetMapping("/login")
    public String lgoin(){
        return "/user/login";
    }

}
