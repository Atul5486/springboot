package com.Basic_Authentication.utils;

import lombok.Data;

@Data
public class Response {

    private String message;
    private Object res;

    public Response() {
    }

    public Response(String message, Object res){
        this.message=message;
        this.res=res;
    }

}
