package com.example.administrator.travel_app.bean;

public class NormalBean {
    String title;
    String message;

    public NormalBean(String title,String message){
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
