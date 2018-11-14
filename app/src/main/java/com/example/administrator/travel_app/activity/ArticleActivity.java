package com.example.administrator.travel_app.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.util.SaveDataUtil;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.administrator.travel_app.config.ApiConstant.SCREEN_HEIGHT;
import static com.example.administrator.travel_app.config.ApiConstant.SCREEN_WIDTH;

public class ArticleActivity extends AppCompatActivity {
    private static final String TAG = "ArticleActivity";

    @BindView(R.id.ac_aritcle_image)
    ImageView imageView;

    int height;
    int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);

        width = Integer.valueOf(SaveDataUtil.getValueFromSharedPreferences(this,SCREEN_WIDTH));

        Glide.with(this).load(R.drawable.article_1).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                height = width * resource.getMinimumHeight() / resource.getMinimumWidth();
                imageView.setImageDrawable(resource);
                Log.i(TAG, "onResourceReady: height = "+ height);
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) imageView.getLayoutParams();
        //获取当前控件的布局对象
        params.height= height;//设置当前控件布局的高度
        params.weight = width;
        imageView.setLayoutParams(params);//将设置好的布局参数应用到控件中
    }
}
