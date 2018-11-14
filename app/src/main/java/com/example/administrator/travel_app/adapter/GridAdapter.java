package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.GridBean;

import java.util.List;

public class GridAdapter extends BaseQuickAdapter<GridBean,BaseViewHolder> {

    private Context context;

    public GridAdapter(@Nullable List<GridBean> data, Context context) {
        super(R.layout.item_grid, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, GridBean item) {
        helper.setText(R.id.item_grid_text,item.getName());
        Glide.with(context).load(item.getImgID()).into((ImageView) helper.getView(R.id.item_grid_image));
    }
}
