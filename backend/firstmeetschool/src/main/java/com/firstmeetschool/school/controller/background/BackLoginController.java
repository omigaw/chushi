package com.firstmeetschool.school.controller.background;

import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BackLoginController {

    @RequestMapping(value = "/login")
    public String hello(){
        return "login";
    }
    @ResponseBody
    @RequestMapping(value = "/login/verify")
    public String verify(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password){
        System.out.println(userName);
        System.out.println(password);
        return "success";
    }
}
