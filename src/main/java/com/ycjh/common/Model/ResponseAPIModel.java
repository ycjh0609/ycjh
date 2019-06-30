package com.ycjh.common.Model;

import lombok.*;

@ToString
public class ResponseAPIModel {

    private Object model;
    private boolean isSuccess;


    public ResponseAPIModel(Object model, boolean isSuccess){
        this.model = model;
        this.isSuccess = isSuccess;
    }
    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

}
