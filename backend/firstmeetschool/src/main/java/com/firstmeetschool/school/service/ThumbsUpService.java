package com.firstmeetschool.school.service;

import com.firstmeetschool.school.entity.Result;
import com.firstmeetschool.school.entity.ThumbsUp;
import com.firstmeetschool.school.mapper.ThumbsUpMapper;
import com.firstmeetschool.school.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ThumbsUpService {

    @Autowired(required = false)
    private ThumbsUpMapper thumbsUpMapper;



    public Result saveThumbsRecord(ThumbsUp thumbsUp){

        Date date = new Date();


        try {
            int result = thumbsUpMapper.insert(thumbsUp.getThumbsedid(), thumbsUp.getNickname(),
                    thumbsUp.getSex(), thumbsUp.getBirthDate(), thumbsUp.getHeight(),
                    thumbsUp.getEducation(), thumbsUp.getHeadpicture(), thumbsUp.getThumbsId(),
                    date.getTime());
            return ResultUtils.success(200,"点赞成功");
        }catch (Exception e){
            return ResultUtils.error(201,"点赞失败");
        }
    }

    public Result searchThumbsObject(int id){

        Map<String,Object> all = new HashMap<>();

        List<ThumbsUp>  whoToMe = new ArrayList<ThumbsUp>();
        List<ThumbsUp>  meToWho = new ArrayList<ThumbsUp>();
        whoToMe = thumbsUpMapper.searchWhoToMe(id);

        meToWho = thumbsUpMapper.searchIToWho(id);

        List<Object>  wTm = new ArrayList<Object>();
        for(ThumbsUp record:whoToMe){
            Map<String,Object> hashMap= new HashMap<String,Object>();
            hashMap.put("date",record.getThumbsTime());
            hashMap.put("nickname",record.getNickname());
            hashMap.put("sex",record.getSex());
            hashMap.put("birthDate",record.getBirthDate());
            hashMap.put("height",record.getHeight());
            hashMap.put("headpicture",record.getHeadpicture());
            hashMap.put("education",record.getEducation());
            wTm.add(hashMap);
        }


        all.put("whoThumbsupMeList",wTm);


        List<Object>  mTw = new ArrayList<Object>();
        for(ThumbsUp record:meToWho){
            Map<String,Object> hashMap= new HashMap<String,Object>();
            hashMap.put("date",record.getThumbsTime());
            hashMap.put("nickname",record.getNickname());
            hashMap.put("sex",record.getSex());
            hashMap.put("birthDate",record.getBirthDate());
            hashMap.put("height",record.getHeight());
            hashMap.put("headpicture",record.getHeadpicture());
            hashMap.put("education",record.getEducation());
            mTw.add(hashMap);
        }

        all.put("IThumbsupWhoList",mTw);


       return ResultUtils.success(200,all);

    }

}
