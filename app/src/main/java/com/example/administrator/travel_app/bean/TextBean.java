package com.example.administrator.travel_app.bean;

import android.graphics.Color;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.Random;

import static com.example.administrator.travel_app.bean.RecyclerTop.TEXT;

public class TextBean implements MultiItemEntity {
    private String text;
    int color;

    int[] colors = { Color.parseColor("#eb0303"), Color.parseColor("#0054ff"), Color.parseColor("#ffc600"), Color.parseColor("#a8ede1"),
            Color.parseColor("#facd89"), Color.parseColor("#cce5f6"),Color.parseColor("#fe6a01"), Color.parseColor("#565656")
            , Color.parseColor("#333333"),Color.parseColor("#f4658b")};

    public TextBean(String s) {
        text = s;
        int random = new Random().nextInt();
        random = random>0?random:-random;
        color = colors[random % colors.length];
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getItemType() {
        return TEXT;
    }
}
