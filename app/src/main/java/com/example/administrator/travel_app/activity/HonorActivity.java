package com.example.administrator.travel_app.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.VerticalStepView;
import com.baoyachi.stepview.bean.StepBean;
import com.example.administrator.travel_app.R;

import java.util.ArrayList;
import java.util.List;

public class HonorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honor);

        VerticalStepView setpview = findViewById(R.id.step_view);
        List<String> list0 = new ArrayList<>();
        list0.add("华清池  \n《长恨歌》 演出场次：单场（20: 30-21:40），双场（20:10-21:20第一场、21:40-22:50第二场）");
        list0.add("永宁门  \n主要演出：《梦长安——大唐迎宾盛礼》");
        list0.add("钟鼓楼  \n（8:00-22:00），城墙（08:00—22:00/19:00）");
        list0.add("高家大院   \n演出时间：皮影戏（10:00-21:20），老腔（11:30-12:30,16:30-20:00,21:45）");
        list0.add("城墙  \n（永宁门、角楼）—钟");
        list0.add("鼓楼—景观大街   \n（东西、南北大街）");
        list0.add("西安北院门144号民居  \n门票价格：15元/人起");
        list0.add("大唐不夜城   \n饱览现代西安的魅丽夜颜");

        setpview.setStepsViewIndicatorComplectingPosition(0)//设置完成的步数
                .reverseDraw(false)//default is true
                .setStepViewTexts(list0)//总步骤
                .setLinePaddingProportion(1.85f)//设置indicator线与线间距的比例系数
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.drawable.complted))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.drawable.default_icon))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.drawable.attention));//设置StepsViewIndicator AttentionIcon


    }
}
