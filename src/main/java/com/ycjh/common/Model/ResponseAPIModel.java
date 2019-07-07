package com.ycjh.common.Model;

import lombok.*;

@ToString
public class ResponseAPIModel {

    private Object model;
    private boolean success;

    public ResponseAPIModel(Object model){
        this.model = model;
        this.success = true;
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

}
