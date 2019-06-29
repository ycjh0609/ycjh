package com.ycjh.user.controller;

import com.ycjh.user.model.UserModel;
import com.ycjh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    /**
     * @DESC forwarding login html
     * @param session
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        UserModel userModel = new UserModel();
        userModel.setUser_id("001");
        userService.selectUserOne(userModel);

        return "user/login";
    }

}
