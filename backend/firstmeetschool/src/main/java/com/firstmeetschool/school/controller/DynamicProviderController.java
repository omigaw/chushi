package com.firstmeetschool.school.controller;

import com.firstmeetschool.school.entity.User;
import com.firstmeetschool.school.service.DynamicProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DynamicProviderController {

    @Autowired(required = false)
    DynamicProviderService dynamicProviderService;

    @RequestMapping(value = "/dyn/{usrId}", method = RequestMethod.GET)
    public User getTestUsrById(@PathVariable("usrId") Integer usrId){

        User res =  dynamicProviderService.findUserById(usrId);
        return res;
    }


    @RequestMapping(value = "/dyn/homepage", method = RequestMethod.GET)
    public List<User> getTestUsrInHomepage(String usrSex, String isStudent, String usrEducation){
        User user1 = new User();
        user1.setUsrSex(usrSex);
        user1.setIsStudent(isStudent);
        user1.setUsrEducation(usrEducation);
        List<User> results = dynamicProviderService.findUserInHomePage(user1);
        return results;
    }


    //TODO: get usrId first

    @RequestMapping(value = "/dyn/update", method = RequestMethod.POST)
    public int updateUserInfo(User user){
        return dynamicProviderService.dynUpdateUser(user);
    }


    @RequestMapping(value = "/dyn/insert", method = RequestMethod.POST)
    public String insertOneUser(User user){
        if(dynamicProviderService.insertNewUser(user) == 1){
            return "success";
        }else{
            return "fail";
        }
    }
}
