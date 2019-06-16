package com.ycjh.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

    public static String toJsonString(Object obj) {
        String jsonString="";
        try {
            ObjectMapper om = new ObjectMapper();
            jsonString =om.writeValueAsString(obj);
        }catch(Exception e) {
            jsonString = "{errmsg:'"+e.getMessage()+"'}";
        }
        return jsonString;
    }




}
