package com.example.administrator.travel_app.bean;

import java.io.Serializable;

public class ScenceBean implements Serializable{
    String title;
    int[] imgID;
    int introduce;
    String describe;
    String price;
    String position;
    String location;
    String time;
    String lable;
    String phone;
    int id ;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getImgID() {
        return imgID;
    }

    public void setImgID(int[] imgID) {
        this.imgID = imgID;
    }

    public int getIntroduce() {
        return introduce;
    }

    public void setIntroduce(int introduce) {
        this.introduce = introduce;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
