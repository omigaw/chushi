package com.firstmeetschool.school.service.Impl;

import com.firstmeetschool.school.entity.User;
import com.firstmeetschool.school.mapper.DynamicProviderMapper;
import com.firstmeetschool.school.service.DynamicProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DynamicProviderServiceImpl implements DynamicProviderService {
    @Autowired(required = false)
    DynamicProviderMapper DynamicProviderMapper;

    @Override
    public User findUserById(Integer id){
        return DynamicProviderMapper.findUserById(id);
    }

    @Override
    public List<User> findUserByNameSql(String usrName){
        return DynamicProviderMapper.findUserByNameSql(usrName);
    }

    @Override
    public List<User> findUserInHomePage(User user){
        Map<String, Object> maps = new HashMap<>();
        maps.put("usrSex", user.getUsrSex());
        maps.put("isStudent", user.getIsStudent());
        maps.put("usrEducation", user.getUsrEducation());
        return DynamicProviderMapper.findUserInHomePage(maps);
    }

    @Override
    public int dynUpdateUser(User user){
        User tmpUser = findUserById(user.getUsrId());

        tmpUser.setUsrWechat(user.getUsrWechat());
        tmpUser.setUsrName(user.getUsrName());
        tmpUser.setUsrTelephone(user.getUsrTelephone());
        tmpUser.setUsrHeight(user.getUsrHeight());
        tmpUser.setUsrAge(user.getUsrAge());
        tmpUser.setHomeTown(user.getHomeTown());
        tmpUser.setCurrentCity(user.getCurrentCity());
        tmpUser.setUsrSex(user.getUsrSex());
        tmpUser.setUsrEducation(user.getUsrEducation());
        tmpUser.setIsStudent(user.getIsStudent());
        tmpUser.setAtUniversity(user.getAtUniversity());
        tmpUser.setGradUniversity(user.getGradUniversity());
        tmpUser.setUsrHobby(user.getUsrHobby());
        tmpUser.setBirthDay(user.getBirthDay());
        tmpUser.setUsrMotto(user.getUsrMotto());
        tmpUser.setSelfIntro(user.getSelfIntro());
        tmpUser.setUsrPicture(user.getUsrPicture());
        tmpUser.setLoverExpect(user.getLoverExpect());
        tmpUser.setSayWords(user.getSayWords());
        tmpUser.setInvitationCards(user.getInvitationCards());
        tmpUser.setCalloutNum(user.getCalloutNum());

        return DynamicProviderMapper.dynUpdateUser(tmpUser);
    }

    @Override
    public int insertNewUser(User user){
        return DynamicProviderMapper.insertNewUser(user);
    }

}
