package com.firstmeetschool.school.controller;


import com.firstmeetschool.school.domain.Result;
import com.firstmeetschool.school.repository.UserRepository;
import com.firstmeetschool.school.domain.User;
import com.firstmeetschool.school.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户信息
     * @return
     */

   @GetMapping(value = "/user")
   public List<User> userList(){
       return userRepository.findAll();
   }


    /**
     * 添加一个用户
     * @return
     */
   @PostMapping(value = "/user")
   public Result<User> usrAdd(@Valid User user, BindingResult bindingResult){

       if(bindingResult.hasErrors()){

           return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
       }


       user.setUsrWechat(user.getUsrWechat());
       user.setUsrName(user.getUsrName());
       //user.setUsrPicture(usrPicture);
       user.setUsrAge(user.getUsrAge());
       user.setUsrSex(user.getUsrSex());
       user.setUsrHeight(user.getUsrHeight());
       //user.setBirthDay(birthDay);
       user.setUsrMotto(user.getUsrMotto());
       user.setNickName(user.getNickName());
       user.setIsStudent(user.getIsStudent());
       user.setAtUniversity(user.getAtUniversity());
       user.setGradUniversity(user.getGradUniversity());
       user.setHomeTown(user.getHomeTown());
       user.setCurrentCity(user.getCurrentCity());
       user.setSelfIntro(user.getSelfIntro());
       user.setLoverExpect(user.getLoverExpect());
       user.setSayWords(user.getSayWords());
       user.setInvitationCards(user.getInvitationCards());
       user.setCalloutNum(user.getCalloutNum());



       return ResultUtils.success(userRepository.save(user));
   }


    /**
     * 查询一个用户
     * @param id
     * @return
     */

   @GetMapping(value = "/user/{id}")
    public User userFindOne(@PathVariable("id") Integer id){
       return userRepository.findById(id).get();
   }

//   @DeleteMapping(value = "/user/{Id}")
//    public void userDelete(@PathVariable("Id") Integer id){
//       userRepository.deleteById(id);
//   }

    /**
     * 用户更新自己的信息
     * @param id
     * @param usrWechat
     * @param usrName
     * @param usrAge
     * @param usrSex
     * @param usrHeight
     * @param usrMotto
     * @param nickName
     * @param isStudent
     * @param atUniversity
     * @param gradUniversity
     * @param homeTown
     * @param currentCity
     * @param selfIntro
     * @param loverExpect
     * @param sayWords
     * @param invitationCards
     * @param calloutNum
     * @return
     */
    @PostMapping(value = "/user/{id}")
    public User userChangeSelf(@PathVariable("id") Integer id,
                               @RequestParam("usrWechat") String usrWechat,
                               @RequestParam("usrName") String usrName,
                               //@RequestParam("usrPicture") byte[] usrPicture,
                               @RequestParam("usrAge") Integer usrAge,
                               @RequestParam("usrSex") String usrSex,
                               @RequestParam("usrHeight") Float usrHeight,
                               //@RequestParam("birthDay") Timestamp birthDay,
                               @RequestParam("usrMotto") String usrMotto,
                               @RequestParam("nickName") String nickName,
                               @RequestParam("isStudent") String isStudent,
                               @RequestParam("atUniversity") String atUniversity,
                               @RequestParam("gradUniversity") String gradUniversity,
                               @RequestParam("homeTown") String  homeTown,
                               @RequestParam("currentCity") String currentCity,
                               @RequestParam("selfIntro")String selfIntro,
                               @RequestParam("loverExpect")String loverExpect,
                               @RequestParam("sayWords")String sayWords,
                               @RequestParam("invitationCards") Integer invitationCards,
                               @RequestParam("calloutNum") Integer calloutNum){

        User user = new User();
        user.setUsrId(id);
        user.setUsrWechat(usrWechat);
        user.setUsrName(usrName);
        //user.setUsrPicture(usrPicture);
        user.setUsrAge(usrAge);
        user.setUsrSex(usrSex);
        user.setUsrHeight(usrHeight);
        //user.setBirthDay(birthDay);
        user.setUsrMotto(usrMotto);
        user.setNickName(nickName);
        user.setIsStudent(isStudent);
        user.setAtUniversity(atUniversity);
        user.setGradUniversity(gradUniversity);
        user.setHomeTown(homeTown);
        user.setCurrentCity(currentCity);
        user.setSelfIntro(selfIntro);
        user.setLoverExpect(loverExpect);
        user.setSayWords(sayWords);
        user.setInvitationCards(invitationCards);
        user.setCalloutNum(calloutNum);

        return userRepository.save(user);
    }
}
