package com.example.administrator.travel_app.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.travel_app.Data;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.activity.MainActivity;
import com.example.administrator.travel_app.activity.ModuleActivity;
import com.example.administrator.travel_app.activity.ScenicActivity;
import com.example.administrator.travel_app.activity.SearchActivity;
import com.example.administrator.travel_app.activity.WebActivity;
import com.example.administrator.travel_app.adapter.GridAdapter;
import com.example.administrator.travel_app.adapter.ModuleAdapter;
import com.example.administrator.travel_app.adapter.ScenceAdapter;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.ModuleBean;
import com.example.administrator.travel_app.bean.ScenceBean;
import com.example.administrator.travel_app.util.ImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import butterknife.BindView;

import static com.example.administrator.travel_app.config.Constant.ScenceID;

/**
 * Created by wanhao on 2018/2/23.
 */

public class MainFragment extends LazyLoadFragment {
    private static final String TAG = "MainFragment";

    private static final int[] CITY_IMG = {R.drawable.city_0,R.drawable.city_4, R.drawable.city_2, R.drawable.city_3};

    @BindView(R.id.fg_main_banner)
    Banner banner;
    @BindView(R.id.fg_main_frag)
    RecyclerView frag;
    @BindView(R.id.fg_main_scence)
    RecyclerView scence;
    @BindView(R.id.fg_main_search)
    TextView search;


    @Override
    protected int setContentView() {
        return R.layout.fragment_main;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceStat) {

        List<Integer> list = new ArrayList<>();
        for(int id:CITY_IMG){
            list.add(id);
        }
        banner.setImageLoader(new ImageLoader());
        banner.setImages(list);
        banner.start();

        //------------------------------------------------------------------------------------------

        frag.setLayoutManager(new GridLayoutManager(getContext(), 2));
        List<ModuleBean> moduleList = Data.getMoudleData();
        ModuleAdapter moduleAdapter = new ModuleAdapter(moduleList,getContext());
        frag.setAdapter(moduleAdapter);
        frag.setNestedScrollingEnabled(false);
        moduleAdapter.setOnItemClickListener((adapter12, view, position) -> {
            if(position == 0)
                startActivity(new Intent(getContext(), ModuleActivity.class));
            else
                Toast.makeText(getContext(),"该模块正在建设中...",Toast.LENGTH_SHORT).show();
        });
        //------------------------------------------------------------------------------------------

        scence.setLayoutManager(new LinearLayoutManager(getContext()));
        List<ScenceBean> scenceList = Data.getScenceData(false);


        ScenceAdapter scenceAdapter = new ScenceAdapter(scenceList,getContext());
        scence.setAdapter(scenceAdapter);
        scence.setNestedScrollingEnabled(false);
        scenceAdapter.setOnItemClickListener((adapter1, view, position) -> {
            ScenceID = position;
            Intent intent = new Intent(getContext(),ScenicActivity.class);
            intent.putExtra("data",scenceList.get(position));
            startActivity(intent);
        });

        search.setOnClickListener(v -> startActivity(new Intent(getContext(), SearchActivity.class)));
    }

}
