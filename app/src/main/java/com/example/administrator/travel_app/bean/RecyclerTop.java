package com.example.administrator.travel_app.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

public class RecyclerTop implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int TOP = 2;

    String text;

    public RecyclerTop(String menu) {
        text = menu;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getItemType() {
        return TOP;
    }
}
