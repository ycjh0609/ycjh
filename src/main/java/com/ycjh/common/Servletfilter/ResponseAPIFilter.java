package com.ycjh.common.Servletfilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycjh.common.Model.ResponseAPIModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.io.IOException;

public class ResponseAPIFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ResponseAPIWrapper wrapper = new ResponseAPIWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrapper);



    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}