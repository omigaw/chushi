package com.firstmeetschool.school.entity;

public class Accuse {

    private int id;    //被举报者id

    private String content;

    private String type;

    private int reporterId;  //举报者id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getReporterId() {
        return reporterId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    @Override
    public String toString() {
        return "Accuse{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", reporterId='" + reporterId + '\'' +
                '}';
    }
}
