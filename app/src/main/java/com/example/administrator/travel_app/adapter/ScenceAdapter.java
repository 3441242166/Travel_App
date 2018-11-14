package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.ScenceBean;

import java.util.List;

public class ScenceAdapter extends BaseQuickAdapter<ScenceBean,BaseViewHolder> {

    private Context context;

    public ScenceAdapter(@Nullable List<ScenceBean> data, Context context) {
        super(R.layout.item_scence, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ScenceBean item) {
        helper.setText(R.id.item_scence_message,item.getDescribe());
        helper.setText(R.id.item_scence_title,item.getTitle());
        helper.setText(R.id.item_scence_pos,item.getPosition());
        helper.setText(R.id.item_scence_lable,item.getLable());
        Glide.with(context).load(item.getImgID()[0]).into((ImageView) helper.getView(R.id.item_scence_img));
    }
}