package com.firstmeetschool.school.mapper;

import com.firstmeetschool.school.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface SelectMapper {

    @Select("select * from user")
    List<User> findAllUsersList();

    @Select("select * from user where usrId = #{usrId}")
    User findUserById(@Param("usrId") int usrId);

    @Select("select usrName,usrSex,usrPicture from user where usrId = #{usrId}")
    Map<String,Object> findInviteById(@Param("usrId") int usrId);

    @Select("select * from user where openid = #{openid}")
    User findUserByopenid(@Param("openid") String openid);

    @Select("SELECT * FROM user WHERE usrName = #{usrName}")
    List<User> findUserByName(@Param("usrName") String usrName);

    @Select("SELECT * FROM user WHERE usrSex = #{usrSex} AND usrEducation = #{usrEducation} AND isStudent = #{isStudent}")
    List<User> filterHomePage(@Param("usrSex") String usrSex, @Param("usrEducation") String usrEducation,
                              @Param("isStudent") String isStudent);



}
