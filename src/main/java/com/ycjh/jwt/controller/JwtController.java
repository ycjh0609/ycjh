package com.ycjh.jwt.controller;

import com.ycjh.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/jwt/create")
    public String createJwt(HttpServletRequest res) throws Exception {

        return jwtService.makeJwt(res);
    }

    @GetMapping("/jwt/auth")
    public boolean authToken(HttpServletRequest res) throws Exception {
        String jwt = res.getParameter("jwt");

        if(jwt == null) {
            return false;
        }else {
            return jwtService.checkJwt(jwt);
        }
    }
}
