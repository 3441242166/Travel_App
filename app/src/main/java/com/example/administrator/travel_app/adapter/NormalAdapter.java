package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.NormalBean;

import java.util.List;

public class NormalAdapter extends BaseQuickAdapter<NormalBean,BaseViewHolder> {

    private Context context;

    public NormalAdapter(@Nullable List<NormalBean> data, Context context) {
        super(R.layout.item_normal, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NormalBean item) {
        helper.setText(R.id.item_normal_title,item.getTitle());
        helper.setText(R.id.item_normal_message,item.getMessage());
    }
}