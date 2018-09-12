package com.firstmeetschool.school.entity;

public class Invitation {

    private int inviterId;

    private String content;

    private int invitedId;

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getInviterId() {
        return inviterId;
    }

    public void setInviterId(int inviterId) {
        this.inviterId = inviterId;
    }

    public int getInvitedId() {
        return invitedId;
    }

    public void setInvitedId(int invitedId) {
        this.invitedId = invitedId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
