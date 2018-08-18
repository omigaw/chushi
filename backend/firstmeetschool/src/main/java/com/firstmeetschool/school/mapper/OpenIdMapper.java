package com.firstmeetschool.school.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OpenIdMapper {


    @Insert("INSERT INTO openid(openid) VALUES(#{openid})")
    int insert(@Param("openid") String openid);

    @Select("SELECT * FROM openid WHERE openid = #{openid}")
    int find(@Param("openid") String openid);
}
