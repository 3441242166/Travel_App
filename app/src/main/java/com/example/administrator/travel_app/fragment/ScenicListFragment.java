package com.example.administrator.travel_app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.travel_app.Data;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.activity.ScenicActivity;
import com.example.administrator.travel_app.adapter.ScenceAdapter;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.bean.ScenceBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class ScenicListFragment extends LazyLoadFragment {

    @BindView(R.id.fg_sceniclist_recycler)
    RecyclerView scence;

    @Override
    protected int setContentView() {
        return R.layout.fragment_scenic_list;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceStat) {
        scence.setLayoutManager(new LinearLayoutManager(getContext()));
        List<ScenceBean> scenceList = Data.getModleData();

        ScenceAdapter scenceAdapter = new ScenceAdapter(scenceList,getContext());
        scence.setAdapter(scenceAdapter);
        scence.setNestedScrollingEnabled(false);
        scenceAdapter.setOnItemClickListener((adapter1, view, position) -> {
            Intent intent = new Intent(getContext(),ScenicActivity.class);
            intent.putExtra("data",scenceList.get(position));
            startActivity(intent);
        });
    }

}
