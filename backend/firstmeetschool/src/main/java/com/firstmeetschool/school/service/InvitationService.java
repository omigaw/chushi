package com.firstmeetschool.school.service;


import com.firstmeetschool.school.entity.Invitation;
import com.firstmeetschool.school.entity.Result;
import com.firstmeetschool.school.mapper.InvitationMapper;
import com.firstmeetschool.school.mapper.SelectMapper;
import com.firstmeetschool.school.mapper.UpdateMapper;
import com.firstmeetschool.school.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvitationService {

    @Autowired(required = false)
    private InvitationMapper invitationMapper;

    @Autowired(required = false)
    private UpdateMapper updateMapper;

    @Autowired(required = false)
    private SelectMapper selectMapper;

    public Result insert(Invitation invitation){

        int card =updateMapper.selectCards( invitation.getInviterId());
        if(card<1){
            return ResultUtils.success(201,"邀约卡不够");
        }
        updateMapper.updateCards(invitation.getInviterId(),card-1);


        Date date = new Date();

        int result=invitationMapper.insert(invitation.getInviterId(),
                invitation.getContent(),invitation.getInvitedId(),date.getTime());
        return ResultUtils.success(200,"邀约成功");
    }

    public Result searchInviteObject(int usrId){

        Map<String,Object> all = new HashMap<>();

        List<Invitation> whoToMe = invitationMapper.searchWhoToMe(usrId);

        List<Invitation> IToWhom = invitationMapper.searchIToWhom(usrId);


        List<Object>  wTm = new ArrayList<Object>();
        for(Invitation record:whoToMe){
            Map<String,Object> hashMap = new HashMap<>();
            hashMap.put("state",record.getState());
            hashMap.put("hello",record.getContent());

            Map<String,Object> eachInviter = selectMapper.findInviteById(record.getInviterId());

            hashMap.put("usrName",eachInviter.get("usrName"));
            hashMap.put("usrSex",eachInviter.get("usrSex"));
            hashMap.put("usrPicture",eachInviter.get("usrPicture"));
            wTm.add(hashMap);
        }

        all.put("whoInviteMeList",wTm);

        List<Object> mTw = new ArrayList<>();
        for(Invitation record:IToWhom){
            Map<String,Object> hashMap = new HashMap<>();
            hashMap.put("state",record.getState());
            hashMap.put("hello",record.getContent());

            Map<String,Object> eachInviter = selectMapper.findInviteById(record.getInvitedId());

            hashMap.put("usrName",eachInviter.get("usrName"));
            hashMap.put("usrSex",eachInviter.get("usrSex"));
            hashMap.put("usrPicture",eachInviter.get("usrPicture"));
            mTw.add(hashMap);
        }
        all.put("IInviteWhomList",mTw);

        return ResultUtils.success(200,all);
    }

    public void changeState(Invitation invitation){
        invitationMapper.changeState(invitation.getState(),invitation.getInvitedId(),invitation.getInviterId());
    }
}
