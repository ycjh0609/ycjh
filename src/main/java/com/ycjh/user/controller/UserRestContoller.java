package com.ycjh.user.controller;


import com.ycjh.user.model.UserModel;
import com.ycjh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserRestContoller {

    @Autowired
    UserService userService;

    /**
     * @DESC do loginAction
     * @param userModel
     * @param session
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public String login(UserModel userModel, HttpSession session, HttpServletRequest request, HttpServletResponse response){

        return "";
    }


}
