package com.firstmeetschool.school.mapper;

import com.firstmeetschool.school.entity.ThumbsUp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ThumbsUpMapper {


    @Insert("INSERT INTO thumbsup(thumbsedid,nickname,sex,birthdate,height,education,headpicture,thumbsid,thumbsTime)"
            +"VALUES(#{thumbsedid},#{nickname},#{sex},#{birthdate},#{height},#{education},#{headpicture},#{thumbsid},#{thumbsTime})")
    int insert(@Param("thumbsedid") int thumbsedid, @Param("nickname") String nickname,
               @Param("sex") String sex, @Param("birthdate") String birthdate,
               @Param("height") String height,@Param("education") String education,
               @Param("headpicture") String headpicture,@Param("thumbsid") int thumbsid,
               @Param("thumbsTime") Long thumbsTime);

    @Select("select * from thumbsup where thumbsedid = #{thumbsedid}")
    List<ThumbsUp> searchWhoToMe(@Param("thumbsedid") int thumbsedid);

    @Select("select * from thumbsup where thumbsid = #{thumbsid}")
    List<ThumbsUp> searchIToWho(@Param("thumbsid") int thumbsid);
}
