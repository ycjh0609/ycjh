package com.ycjh.error.controller;


import com.ycjh.common.Model.ResponseAPIModel;
import com.ycjh.common.util.JSONUtil;
import com.ycjh.error.Model.ErrorModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

    private final String PATH = "/error";
    Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    @RequestMapping(value = PATH)
    public ResponseAPIModel error(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));
        String statusCode = String.valueOf(status);

        logger.error("httpStatus: "+httpStatus);
        //logger.error("StatusCode: "+statusCode);

        // to-do : error service
        ErrorModel errorModel = new ErrorModel();
        errorModel.setStatusCode(statusCode);
        errorModel.setHttpStatus(httpStatus.getReasonPhrase());
        ResponseAPIModel responseAPIModel = new ResponseAPIModel(errorModel,false);
        return responseAPIModel;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
