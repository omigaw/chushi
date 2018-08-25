package com.firstmeetschool.school.utils;

import com.firstmeetschool.school.entity.Result;

public class ResultUtils {


    public static Result success(int statusCode,Object object){
        Result result = new Result();
        result.setStatusCode(statusCode);
        result.setData(object);
        return result;
    }


    public static Result error(Integer statusCode,String msg){
        Result result = new Result();
        result.setStatusCode(statusCode);
        result.setData(msg);
        return result;
    }
}
