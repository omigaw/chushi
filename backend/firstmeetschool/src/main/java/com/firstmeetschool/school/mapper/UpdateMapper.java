package com.firstmeetschool.school.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UpdateMapper {

    @Update("update user set usrWechat = #{usrWechat}, usrName = #{usrName}, usrTelephone = #{usrTelephone}, " +
            "usrHeight = #{usrHeight}, usrAge = #{usrAge}, homeTown = #{homeTown}, currentCity = #{currentCity}, " +
            "usrSex = #{usrSex},  usrEducation = #{usrEducation}, isStudent = #{isStudent}")
    int updateUser(@Param("usrWechat") String usrWechat, @Param("usrName") String usrName, @Param("usrTelephone") String usrTelephone,
                   @Param("usrHeight") String usrHeight, @Param("usrAge") String usrAge, @Param("homeTown") String homeTown, @Param("currentCity") String currentCity,
                   @Param("usrSex") String usrSex, @Param("usrEducation") String usrEducation, @Param("isStudent") String isStudent);

    @Select("select invitationCards from user where usrId=#{usrId}")
    int selectCards(@Param("usrId") int usrId);


    @Update("update user set invitationCards=#{invitationCards} where usrId = #{usrId}")
    int updateCards(@Param("usrId")int usrId,@Param("invitationCards") int invitationCards);
}
