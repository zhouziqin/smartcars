package com.common;

import java.io.Serializable;

/**
 * created by  zhouzq on 2020/11/4
 * desc
 */
public class JsonResult<T> extends BaseVO implements Serializable {
    private static final long serialVersionUID = -5819736795237643687L;
    private Boolean success = true;
    private String code;
    private String message;
    private T data;
    private Long time = System.currentTimeMillis();

    public JsonResult(T data) {
        this.data = data;
    }

    public JsonResult() {
    }

    public static <T> JsonResult<T> success(T data) {
        JsonResult<T> resp = new JsonResult();
        resp.setSuccess(true);
        resp.setData(data);
        return resp;
    }

    public static <T> JsonResult<T> success() {
        JsonResult<T> resp = new JsonResult();
        resp.setSuccess(true);
        return resp;
    }

    public static <T> JsonResult<T> failure() {
        JsonResult<T> resp = new JsonResult();
        resp.setSuccess(false);
        return resp;
    }

    public static <T> JsonResult<T> failureWithCode(String code) {
        JsonResult<T> resp = new JsonResult();
        resp.setSuccess(false);
        resp.setCode(code);
        return resp;
    }

    public static <T> JsonResult<T> failureWithMessage(String message) {
        JsonResult<T> resp = new JsonResult();
        resp.setSuccess(false);
        resp.setMessage(message);
        return resp;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
