package com.ycjh.common.Model;

import lombok.*;

@ToString
public class ResponseAPIModel {

    private Object model;
    private boolean success;
    private String token;

    public ResponseAPIModel(Object model, boolean success, String token) {
        this.model = model;
        this.success = success;
        this.token = token;
    }

    public ResponseAPIModel(Object model, boolean success) {
        this.model = model;
        this.success = success;
    }


    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
