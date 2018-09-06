package com.firstmeetschool.school.controller;

import com.firstmeetschool.school.entity.Result;
import com.firstmeetschool.school.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;



    /*接口url
    "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code"
    */
    /*@RequestMapping("/login_code/{code}/{state}")
    public  String login(@PathVariable("code") String code, @PathVariable("state") int state){

        String result=loginService.logincode(code,state);

        return result;

    }*/

    /**
     * url请求路径为chance/login_code?code=xxxxxxxx
     * @param code

     * @return
     */
    @RequestMapping(value = "/login_code",produces = "application/json")
    public  Result login(String code){

        System.out.println("js_code:"+code);
        Result result=loginService.logincode(code);

        return result;

    }

}
