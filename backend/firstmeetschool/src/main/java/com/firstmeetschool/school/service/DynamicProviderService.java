package com.firstmeetschool.school.service;

import com.firstmeetschool.school.entity.User;

import java.util.List;

public interface DynamicProviderService {
    User findUserById(Integer id);
    List<User> findUserByNameSql(String usrName);
    List<User> findUserInHomePage(User user);
    int dynUpdateUser(User user);
    int insertNewUser(User user);
}
