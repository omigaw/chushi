package com.firstmeetschool.school.controller;


import com.firstmeetschool.school.entity.Invitation;
import com.firstmeetschool.school.entity.Result;
import com.firstmeetschool.school.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @RequestMapping(value = "/meetwithher",method = RequestMethod.POST)
    public Result meetWithHer(@RequestBody Invitation invitation){

        Result result =invitationService.insert(invitation);
        return result;
    }

    @RequestMapping(value="/myfriendinvitation",method = RequestMethod.GET)
    public Result myFriendInvitation(int usrId){

        return invitationService.searchInviteObject(usrId);

    }

    /**
     * 用户同意state=1，不同意state=2
     */
    @RequestMapping(value = "/changestate",method = RequestMethod.POST)
    public void agreeOrNot(@RequestBody Invitation invitation){
        invitationService.changeState(invitation);
    }
}
