package com.firstmeetschool.school.mapper;


import com.firstmeetschool.school.entity.OpenId;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OpenIdMapper {


    @Insert("INSERT INTO authority(openid,checkReg)"+"VALUES(#{openid},#{checkReg})")
    int insert(@Param("openid") String openid, @Param("checkReg") int checkReg);

    @Select("SELECT * FROM authority WHERE openid = #{openid}")
    OpenId find(@Param("openid") String openid);

    @Update("UPDATE authority set checkReg=1 where openid = #{openid}")
    void updateStatus(@Param("openid")String openid);
}
