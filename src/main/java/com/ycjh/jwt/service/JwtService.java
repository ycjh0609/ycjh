package com.ycjh.jwt.service;

import com.ycjh.user.model.UserModel;

import javax.servlet.http.HttpServletRequest;

public interface JwtService {
    String makeJwt(UserModel userModel);

    boolean checkJwt(String jwt);
}
