package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.PathBean;

import java.util.List;

public class PathAdapter extends BaseQuickAdapter<PathBean,BaseViewHolder> {

    private Context context;

    public PathAdapter(@Nullable List<PathBean> data, Context context) {
        super(R.layout.item_path, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PathBean item) {
        helper.setText(R.id.item_path_title,item.getTitle());
        Glide.with(context).load(item.getImgPath()).into((ImageView) helper.getView(R.id.item_path_bck));
    }
}
