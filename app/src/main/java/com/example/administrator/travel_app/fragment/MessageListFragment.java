package com.example.administrator.travel_app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.activity.ArticleActivity;
import com.example.administrator.travel_app.activity.WebActivity;
import com.example.administrator.travel_app.adapter.NewsAdapter;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.bean.NewsBean;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;

import butterknife.BindView;

public class MessageListFragment extends LazyLoadFragment {

    @BindView(R.id.fg_list_recycler)
    RecyclerView recyclerView ;
    @BindView(R.id.fg_list_refresh)
    PullToRefreshView refreshView;

    @Override
    protected int setContentView() {
        return R.layout.fragment_message_list;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceStat) {
        initView();
        initEvent();
    }

    private void initEvent() {
        refreshView.setOnRefreshListener(() -> refreshView.postDelayed(() -> {
            refreshView.setRefreshing(false);
        }, 1800));
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<NewsBean> newsList = new ArrayList<>();
        for(int x=0;x<5;x++){
            NewsBean bean= new NewsBean();
            newsList.add(bean);
        }
        NewsAdapter newsAdapter = new NewsAdapter(newsList,getContext());
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        newsAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(getContext(),WebActivity.class);
            intent.putExtra("url","https://baijiahao.baidu.com/s?id=1567818883658472&wfr=spider&for=pc");
            startActivity(intent);
        });
    }
}
