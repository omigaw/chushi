package com.firstmeetschool.school.mapper;

import com.firstmeetschool.school.entity.Invitation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InvitationMapper {

    @Insert("INSERT INTO invitation(inviterId,content,invitedId,time)"
            +"VALUES(#{inviterId},#{content},#{invitedId},#{time})")
    int insert(@Param("inviterId") int inviterId,
               @Param("content") String content, @Param("invitedId") int invitedId,@Param("time") Long time);

    @Select("select * from invitation where invitedId =#{invitedId}")
    List<Invitation> searchWhoToMe(@Param("invitedId")int invitedId);

    @Select("select * from invitation where inviterId =#{inviterId}")
    List<Invitation> searchIToWhom(@Param("inviterId")int inviterId);

    @Update("update invitation set state=#{state} where invitedId =#{invitedId} and inviterId =#{inviterId}")
    int changeState(@Param("state")int state,@Param("invitedId")int invitedId,@Param("inviterId")int inviterId);
}
