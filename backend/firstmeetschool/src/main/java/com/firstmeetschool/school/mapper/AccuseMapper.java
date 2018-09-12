package com.firstmeetschool.school.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccuseMapper {

    @Insert("INSERT INTO accuse(reported_id,type,content,reporter_id)"
            +"VALUES(#{reportedId},#{type},#{content},#{reporterId})")
    int insert(@Param("reportedId") int reportedId, @Param("type") String type,
               @Param("content") String content,@Param("reporterId") int reporterId);

}
