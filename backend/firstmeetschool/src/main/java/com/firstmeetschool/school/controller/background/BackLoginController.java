package com.firstmeetschool.school.controller.background;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BackLoginController {

    private String VIEWPATH = "";

    @RequestMapping(value = "/login")
    public String hello(){
        return "login";
    }

    @RequestMapping(value = "/login/verify")
    public String verify(Model model, @RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password){
        model.addAttribute("model","model:你被支持吗?");


        /*登录认证逻辑*/
        if (1 == 1){
            return "index";
        }else {
            return "login";
        }

    }
}
