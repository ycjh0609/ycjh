package com.ycjh.user.controller;


import com.ycjh.common.util.JSONUtil;
import com.ycjh.user.model.UserModel;
import com.ycjh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    UserService userService;



}
