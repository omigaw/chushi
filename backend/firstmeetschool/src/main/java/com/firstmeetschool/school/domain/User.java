package com.firstmeetschool.school.domain;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer usrId;


    @NotBlank(message = "请输入微信号")
    private String usrWechat;

    @NotBlank(message = "请输入姓名")
    private String usrName;


    // private byte[] usrPicture;

    @Min(value = 18,message = "未成年")
    private Integer usrAge;


    private String usrSex;

    @NotNull(message = "请输入身高" )
    private Float usrHeight;

    // private Timestamp birthDay;

    private String usrMotto;

    @NotNull(message = "请输入昵称" )
    private String nickName;


    private String isStudent;

    private String atUniversity;


    private String gradUniversity;

    @NotNull(message = "请输入家乡" )
    private String homeTown;

    @NotNull(message = "请输入所在城市" )
    private String currentCity;

    private String selfIntro;

    private String loverExpect;

    private String sayWords;


    // 邀请卡
    private Integer invitationCards;

    // 点赞数
    private Integer calloutNum;

    public User() {
        }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrWechat() {
        return usrWechat;
    }

    public void setUsrWechat(String usrWechat) {
        this.usrWechat = usrWechat;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public Integer getUsrAge() {
        return usrAge;
    }

    public void setUsrAge(Integer usrAge) {
        this.usrAge = usrAge;
    }

    public String getUsrSex() {
        return usrSex;
    }

    public void setUsrSex(String usrSex ) {
        this.usrSex = usrSex;
    }

    public Float getUsrHeight() {
        return usrHeight;
    }

    public void setUsrHeight(Float usrHeight) {
        this.usrHeight = usrHeight;
    }

    /*public Timestamp getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }*/

    public String getUsrMotto() {
        return usrMotto;
    }

    public void setUsrMotto(String usrMotto) {
        this.usrMotto = usrMotto;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(String isStudent) {
        this.isStudent = isStudent;
    }

    public String getAtUniversity() {
        return atUniversity;
    }

    public void setAtUniversity(String atUniversity) {
        this.atUniversity = atUniversity;
    }

    public String getGradUniversity() {
        return gradUniversity;
    }

    public void setGradUniversity(String gradUniversity) {
        this.gradUniversity = gradUniversity;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }

    public String getLoverExpect() {
        return loverExpect;
    }

    public void setLoverExpect(String loverExpect) {
        this.loverExpect = loverExpect;
    }

    public String getSayWords() {
        return sayWords;
    }

    public void setSayWords(String sayWords) {
        this.sayWords = sayWords;
    }

    public Integer getInvitationCards() {
        return invitationCards;
    }

    public void setInvitationCards(Integer invitationCards) {
        this.invitationCards = invitationCards;
    }

    public Integer getCalloutNum() {
        return calloutNum;
    }

    public void setCalloutNum(Integer calloutNum) {
        this.calloutNum = calloutNum;
    }

  /*  public byte[] getUsrPicture() {
        return usrPicture;
    }

    public void setUsrPicture(byte[] usrPicture) {
        this.usrPicture = usrPicture;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "usrId=" + usrId +
                ", usrWechat='" + usrWechat + '\'' +
                ", usrName='" + usrName + '\'' +
                ", usrAge=" + usrAge +
                ", usrSex='" + usrSex + '\'' +
                ", usrHeight=" + usrHeight +
                ", usrMotto='" + usrMotto + '\'' +
                ", nickName='" + nickName + '\'' +
                ", isStudent='" + isStudent + '\'' +
                ", atUniversity='" + atUniversity + '\'' +
                ", gradUniversity='" + gradUniversity + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", currentCity='" + currentCity + '\'' +
                ", selfIntro='" + selfIntro + '\'' +
                ", loverExpect='" + loverExpect + '\'' +
                ", sayWords='" + sayWords + '\'' +
                ", invitationCards=" + invitationCards +
                ", calloutNum=" + calloutNum +
                '}';
    }
}
