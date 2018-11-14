package com.example.administrator.travel_app.fragment;

import android.os.Bundle;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.util.ImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DetailIntroduceFragment extends LazyLoadFragment {

    @BindView(R.id.fg_detail_banner)
    Banner banner;

    private static final int[] MOUDLE_IMAEG = {R.drawable.model_0, R.drawable.modle_1,R.drawable.modle_2, R.drawable.modle_3,R.drawable.modle_4};

    @Override
    protected int setContentView() {
        return R.layout.fragment_detail_introduce;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceStat) {

        List<Integer> list = new ArrayList<>();
        for(int id:MOUDLE_IMAEG){
            list.add(id);
        }
        banner.setImageLoader(new ImageLoader());
        banner.setImages(list);
        banner.start();


    }
}
