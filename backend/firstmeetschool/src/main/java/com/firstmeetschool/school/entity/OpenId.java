package com.firstmeetschool.school.entity;

public class OpenId {

    private Integer keyId;

    private String openid;

    private Integer checkReg;

    public Integer getCheckReg() {
        return checkReg;
    }

    public void setCheckReg(Integer checkReg) {
        this.checkReg = checkReg;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
