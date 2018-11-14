package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.TextBean;

import java.util.List;

public class TextAdapter extends BaseQuickAdapter<TextBean,BaseViewHolder> {

    private Context context;

    public TextAdapter(@Nullable List<TextBean> data, Context context) {
        super(R.layout.item_text, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, TextBean item) {
        helper.setText(R.id.item_text_text,item.getText());
        helper.getView(R.id.item_text_layout).setBackgroundColor(item.getColor());
    }
}
