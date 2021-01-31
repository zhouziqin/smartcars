package com.domain.model;

import lombok.Data;

@Data
public class Result<T> {
    int code ;
    String msg;
    T data;
    public Result<T>  success(String msg,T data){
        this.code = 200;
        this.msg = msg;
        this.data = data;
    return null;
    }

}
