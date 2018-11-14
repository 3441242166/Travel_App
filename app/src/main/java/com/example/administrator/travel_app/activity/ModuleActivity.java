package com.example.administrator.travel_app.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.adapter.PagerAdapter;
import com.example.administrator.travel_app.fragment.DetailIntroduceFragment;
import com.example.administrator.travel_app.fragment.IntroduceFragment;
import com.example.administrator.travel_app.fragment.ScenicListFragment;
import com.example.administrator.travel_app.fragment.StrategyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModuleActivity extends AppCompatActivity {

    @BindView(R.id.ac_module_tabs)
    TabLayout tabLayout ;
    @BindView(R.id.ac_module_viewpager)
    ViewPager viewPager;

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        fragmentList = new ArrayList<>();
        fragmentList.add(new DetailIntroduceFragment());
        fragmentList.add(new ScenicListFragment());
        String []ar ={"介绍","景点"};
        viewPager.setAdapter(new PagerAdapter<>(getSupportFragmentManager(), fragmentList, ar));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOverScrollMode(viewPager.OVER_SCROLL_NEVER);
        viewPager.setOffscreenPageLimit(3);
    }
}
