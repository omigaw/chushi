package com.firstmeetschool.school.entity;

public class Result<T> {

    /**
     * 状态码
     * 200    成功
     * 201    未返回正确openid
     * 202    用户认证异常
     */

    private int statusCode;

    private T data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
