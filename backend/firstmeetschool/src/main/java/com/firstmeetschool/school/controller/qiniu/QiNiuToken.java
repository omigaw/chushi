package com.firstmeetschool.school.controller.qiniu;

import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class QiNiuToken {

    private String ak = "QZEqMjCnT0qYxZMgvwwSpbA-jgf7TWyFAxqVRag_";

    private String sk = "y2BBPKYXkxfaY03F9eVKrOy6GHstCHyV_d2JmWmQ";

    @ResponseBody
    @RequestMapping(value = "/qiniutoken")
    public Object getQiniuUptoken() throws Exception{
        Map<String,Object> data = new HashMap<String, Object>();
        Auth auth = Auth.create(ak,sk);
        String uptoken = auth.uploadToken("images");// 使用的空间为每个用户的id
        data.put("uptoken",uptoken);
        return data;


    }
}
