package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.QuestionBean;

import java.util.List;

public class QuestionAdapter extends BaseQuickAdapter<QuestionBean,BaseViewHolder> {

    private Context context;

    public QuestionAdapter(@Nullable List<QuestionBean> data, Context context) {
        super(R.layout.item_question, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, QuestionBean item) {
        helper.setText(R.id.item_question_queston,item.getQuestion());
        helper.setText(R.id.item_question_answer,item.getAnswer());

    }
}