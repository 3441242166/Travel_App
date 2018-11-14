package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.ModuleBean;

import java.util.List;

public class ModuleAdapter extends BaseQuickAdapter<ModuleBean,BaseViewHolder> {

    private Context context;

    public ModuleAdapter(@Nullable List<ModuleBean> data, Context context) {
        super(R.layout.item_module, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ModuleBean item) {
        helper.setText(R.id.item_module_title,item.getTitle());
        Glide.with(context).load(item.getImgID()).into((ImageView) helper.getView(R.id.item_module_img));
    }
}