package com.firstmeetschool.school.service;

import com.firstmeetschool.school.entity.User;


import java.util.List;
import java.util.Map;

public interface DynamicProviderService {

    User findUserById(Integer id);
    List<User> findUserByNameSql(String usrName);
    List<User> findUserInHomePage(Map map);
    int dynUpdateUser(User user);
    int insertNewUser(User user);
}
