package com.ycjh.common.Servletfilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycjh.common.Model.ResponseAPIModel;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class ResponseAPIWrapper extends HttpServletResponseWrapper {

    public ResponseAPIWrapper (HttpServletResponse response){
        super(response);

    }

}
