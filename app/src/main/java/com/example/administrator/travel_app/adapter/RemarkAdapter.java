package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.RemarkBean;

import java.util.List;

public class RemarkAdapter extends BaseQuickAdapter<RemarkBean,BaseViewHolder> {

    private Context context;

    public RemarkAdapter(@Nullable List<RemarkBean> data, Context context) {
        super(R.layout.item_remark, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, RemarkBean item) {
        helper.setText(R.id.item_remark_name,item.name);
        helper.setText(R.id.item_remark_content,item.content);
    }
}