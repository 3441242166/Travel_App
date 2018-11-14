package com.example.administrator.travel_app.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.adapter.NewsAdapter;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.bean.NewsBean;

import java.util.ArrayList;

import butterknife.BindView;

public class StrategyFragment extends LazyLoadFragment {
    @BindView(R.id.fg_strategy_recycler)
    RecyclerView news;

    @Override
    protected int setContentView() {
        return R.layout.fragment_strategy;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceStat) {
        news.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<NewsBean> newsList = new ArrayList<>();
        for(int x=0;x<5;x++){
            NewsBean bean= new NewsBean();
            newsList.add(bean);
        }
        NewsAdapter newsAdapter = new NewsAdapter(newsList,getContext());
        news.setAdapter(newsAdapter);
        news.setNestedScrollingEnabled(false);
    }
}
