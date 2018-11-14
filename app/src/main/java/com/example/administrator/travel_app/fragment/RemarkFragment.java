package com.example.administrator.travel_app.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.adapter.NewsAdapter;
import com.example.administrator.travel_app.adapter.RemarkAdapter;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.bean.NewsBean;
import com.example.administrator.travel_app.bean.RemarkBean;

import java.util.ArrayList;

import butterknife.BindView;

public class RemarkFragment extends LazyLoadFragment {
    @BindView(R.id.fg_remark_recycler)
    RecyclerView recycler;

    @Override
    protected int setContentView() {
        return R.layout.fragment_remark;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceStat) {
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<RemarkBean> newsList = new ArrayList<>();
        for(int x=0;x<10;x++){
            RemarkBean bean= new RemarkBean();
            newsList.add(bean);
        }
        RemarkAdapter newsAdapter = new RemarkAdapter(newsList,getContext());
        recycler.setAdapter(newsAdapter);
        recycler.setNestedScrollingEnabled(false);
    }
}
