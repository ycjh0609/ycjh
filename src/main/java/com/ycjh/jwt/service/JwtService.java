package com.ycjh.jwt.service;

import javax.servlet.http.HttpServletRequest;

public interface JwtService {
    String makeJwt(HttpServletRequest res);

    boolean checkJwt(String jwt);
}
