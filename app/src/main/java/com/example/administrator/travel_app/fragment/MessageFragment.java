package com.example.administrator.travel_app.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.adapter.PagerAdapter;
import com.example.administrator.travel_app.base.LazyLoadFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MessageFragment extends LazyLoadFragment {

    @BindView(R.id.fg_message_tab)
    TabLayout tabLayout ;
    @BindView(R.id.fg_message_viewpager)
    ViewPager viewPager;

    private List<Fragment> fragmentList;

    @Override
    protected int setContentView() {
        return R.layout.fragment_message;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceStat) {
        initView();
    }

    private void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new PathFragment());
        fragmentList.add(new MessageListFragment());
        String []ar ={"线路规划","游记"};
        viewPager.setAdapter(new PagerAdapter<>(getActivity().getSupportFragmentManager(), fragmentList, ar));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOverScrollMode(viewPager.OVER_SCROLL_NEVER);
        viewPager.setOffscreenPageLimit(5);
    }
}
