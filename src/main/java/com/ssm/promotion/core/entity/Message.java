package com.ssm.promotion.core.entity;

import java.io.Serializable;

public class Message implements Serializable {
    private String id;//主键
    private String messageCreateDate;//创建日期
    private String messageContent;//文章内容
    private int messageClassID;//文章类别id
    private int isBad;//置顶字段
    private String addName;//添加者

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageCreateDate() {
        return messageCreateDate;
    }

    public void setMessageCreateDate(String messageCreateDate) {
        this.messageCreateDate = messageCreateDate;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public int getMessageClassID() {
        return messageClassID;
    }

    public void setMessageClassID(int messageClassID) {
        this.messageClassID = messageClassID;
    }

    public int getIsBad() {
        return isBad;
    }

    public void setIsBad(int isBad) {
        this.isBad = isBad;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", messageCreateDate='" + messageCreateDate + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageClassID=" + messageClassID +
                ", isBad=" + isBad +
                ", addName='" + addName + '\'' +
                '}';
    }
}
