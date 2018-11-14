package com.example.administrator.travel_app.fragment;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.adapter.GridAdapter;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.bean.GridBean;

import java.util.ArrayList;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserMessageFragment extends LazyLoadFragment {
    private static final String TAG = "UserMessageFragment";

    private static final String[] USUALLY_TITLE = {"我的钱包", "优惠劵", "我的订单", "我的收藏"};
    private static final int[] USUALLY_IMG = {R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh};

    private static final String[] OTHER_TITLE = {"历史浏览", "我的点评", "社区", "旅游百货", "门市查询", "计划安排", "退出登陆"};
    private static final int[] OTHER_IMG = {R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh, R.mipmap.gv_section, R.mipmap.gv_empty, R.mipmap.gv_drag_and_swipe, R.mipmap.gv_item_click, R.mipmap.gv_expandable, R.mipmap.gv_databinding,R.mipmap.gv_multipleltem};

    private ArrayList<GridBean> usuallyList;
    private ArrayList<GridBean> otherList;
    private GridAdapter usuallyAdapter;
    private GridAdapter otherAdapter;

    @BindView(R.id.fg_my_bck)
    ImageView bck;
    @BindView(R.id.fg_my_head)
    CircleImageView head;
    @BindView(R.id.fg_my_name)
    TextView name;
    @BindView(R.id.fg_my_signature)
    TextView signature;
    @BindView(R.id.fg_my_usually)
    RecyclerView usuallyRecycler;
    @BindView(R.id.fg_my_other)
    RecyclerView otherRecycler;

    @BindView(R.id.fg_my_headlayout)
    ConstraintLayout headLayout;

    @Override
    protected int setContentView() {
        return R.layout.fragment_my;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceStat) {

        usuallyList = new ArrayList<>();
        otherList = new ArrayList<>();

        for(int x=0;x<USUALLY_TITLE.length;x++){
            GridBean bean= new GridBean(USUALLY_IMG[x],USUALLY_TITLE[x]);
            usuallyList.add (bean);
        }

        for(int x=0;x<OTHER_TITLE.length;x++){
            GridBean bean= new GridBean(OTHER_IMG[x],OTHER_TITLE[x]);
            otherList.add(bean);
        }

        usuallyRecycler.setLayoutManager(new GridLayoutManager(getContext(), 4));
        otherRecycler.setLayoutManager(new GridLayoutManager(getContext(), 4));

        usuallyRecycler.setNestedScrollingEnabled(false);
        otherRecycler.setNestedScrollingEnabled(false);

        usuallyAdapter = new GridAdapter(usuallyList,getContext());
        otherAdapter = new GridAdapter(otherList,getContext());

        usuallyRecycler.setAdapter(usuallyAdapter);
        otherRecycler.setAdapter(otherAdapter);

        usuallyRecycler.setNestedScrollingEnabled(false);
        otherRecycler.setNestedScrollingEnabled(false);
    }



}
