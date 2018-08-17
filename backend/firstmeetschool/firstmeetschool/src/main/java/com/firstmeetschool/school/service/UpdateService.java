package com.firstmeetschool.school.service;

import com.firstmeetschool.school.mapper.UpdateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {

    @Autowired
    private UpdateMapper updateMapper;

    public int updateUserInfo(String usrWechat, String usrName, String usrTelephone, String usrHeight, String usrAge,
                              String homeTown, String currentCity, String usrSex, String usrEducatioin, String isStudent ){
        int newUser = this.updateMapper.updateUser(usrWechat, usrName, usrTelephone, usrHeight, usrAge,
                homeTown, currentCity, usrSex, usrEducatioin,isStudent);
        return newUser;
    }
}
