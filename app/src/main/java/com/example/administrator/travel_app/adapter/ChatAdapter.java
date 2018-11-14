package com.example.administrator.travel_app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.ChatBean;
import java.util.List;

/**
 * Created by wanhao on 2018/4/5.
 */

public class ChatAdapter extends BaseQuickAdapter<ChatBean,BaseViewHolder> {

    private Context context;

    public ChatAdapter(@Nullable List<ChatBean> data, Context context) {
        super(R.layout.item_chat_me, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatBean item) {
        helper.setText(R.id.item_char_me_content,item.getContent());
    }
}
