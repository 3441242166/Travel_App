package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.NewsBean;

import java.util.List;

public class NewsAdapter extends BaseQuickAdapter<NewsBean,BaseViewHolder> {

    private Context context;

    public NewsAdapter(@Nullable List<NewsBean> data, Context context) {
        super(R.layout.item_news, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsBean item) {
//        helper.setText(R.id.item_grid_text,item.getName());
//        Glide.with(context).load(item.getImgID()).crossFade().into((ImageView) helper.getView(R.id.item_grid_image));


    }
}