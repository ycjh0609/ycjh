package com.ycjh.jwt.controller;

import com.ycjh.jwt.service.JwtService;
import com.ycjh.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/create")
    public String createJwt(UserModel model) throws Exception {

        return jwtService.makeJwt(model);
    }

    @GetMapping("/auth")
    public boolean authToken(HttpServletRequest res) throws Exception {
        String jwt = res.getParameter("jwt");

        if(jwt == null) {
            return false;
        }else {
            return jwtService.checkJwt(jwt);
        }
    }
}
