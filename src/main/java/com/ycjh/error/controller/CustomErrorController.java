package com.ycjh.error.controller;


import com.ycjh.common.util.JSONUtil;
import com.ycjh.error.Model.ErrorModel;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

    private final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));
        String statusCode = String.valueOf(status);

        // to-do : error service
        ErrorModel errorModel = new ErrorModel();
        errorModel.setStatusCode(statusCode);
        errorModel.setHttpStatus(httpStatus.getReasonPhrase());

        return JSONUtil.toJsonString(errorModel);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
