package com.example.administrator.travel_app.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.bean.RecyclerTop;
import com.example.administrator.travel_app.bean.TextBean;

import java.util.List;

import static com.example.administrator.travel_app.bean.RecyclerTop.TEXT;
import static com.example.administrator.travel_app.bean.RecyclerTop.TOP;

public class MenuAdapter  extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public MenuAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TOP, R.layout.item_head);
        addItemType(TEXT, R.layout.item_text);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TOP:
                final RecyclerTop topBean = (RecyclerTop) item;
                holder.setText(R.id.item_head_title,topBean.getText());
                break;
            case TEXT:
                final TextBean bean = (TextBean) item;
                holder.setText(R.id.item_text_text,bean.getText());
                holder.getView(R.id.item_text_layout).setBackgroundColor(bean.getColor());
                break;
        }
    }

}