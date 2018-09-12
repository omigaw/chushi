package com.firstmeetschool.school.controller;

import com.firstmeetschool.school.entity.Result;
import com.firstmeetschool.school.entity.User;
import com.firstmeetschool.school.mapper.OpenIdMapper;
import com.firstmeetschool.school.service.DynamicProviderService;
import com.firstmeetschool.school.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DynamicProviderController {

    @Autowired(required = false)
    DynamicProviderService dynamicProviderService;

    @Autowired(required = false)
    private OpenIdMapper openIdMapper;

    @RequestMapping(value = "/dyn/findbyid",produces = "application/json")
    public Result getTestUsrById(Integer usrId){

        User res =  dynamicProviderService.findUserById(usrId);
        return ResultUtils.success(200,res);
    }


    @RequestMapping(value = "/dyn/findbyname", method = RequestMethod.GET)
    public Result<List<User>> getTestSameUsrByName(String usrName){
        System.out.println(usrName);
        return ResultUtils.success(200,dynamicProviderService.findUserByNameSql(usrName));
    }


    @RequestMapping(value = "/dyn/homepage", method = RequestMethod.GET)
    public Result<List<User>> getTestUsrInHomepage(String usrSex,int lowAge,int highAge, String usrEducation,String isStudent){
        Map<String,Object> map = new HashMap<>();

        map.put("usrSex",usrSex);
        map.put("lowAge",lowAge);
        map.put("highAge",highAge);
        map.put("usrEducation",usrEducation);
        map.put("isStudent",isStudent);

        List<User> results = dynamicProviderService.findUserInHomePage(map);
        return ResultUtils.success(200,results);
    }


    //TODO: get usrId first

    @RequestMapping(value = "/dyn/update", method = RequestMethod.POST)
    public Result updateUserInfo(User user){
        System.out.println(user);
        return ResultUtils.success(200,dynamicProviderService.dynUpdateUser(user));
    }


    @RequestMapping(value = "/dyn/insert", method = RequestMethod.POST)
    public Result insertOneUser(User user){
        openIdMapper.updateStatus(user.getOpenid());
        if(dynamicProviderService.insertNewUser(user) == 1){
            return ResultUtils.success(200,"1");
        }else{
            return ResultUtils.success(200,"0");
        }
    }
}
