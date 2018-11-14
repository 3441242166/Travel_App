package com.example.administrator.travel_app.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.travel_app.config.ApiConstant.SCREEN_HEIGHT;
import static com.example.administrator.travel_app.config.ApiConstant.SCREEN_WIDTH;
import static com.example.administrator.travel_app.util.SaveDataUtil.saveToSharedPreferences;


/**
 * Created by wanhao on 2018/2/27.
 */

public class BaseApplication extends Application {
    /**
     * 全局的上下文
     */
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int heigth = dm.heightPixels;
        int width = dm.widthPixels;
        saveToSharedPreferences(this,SCREEN_HEIGHT, String.valueOf(heigth));
        saveToSharedPreferences(this,SCREEN_WIDTH, String.valueOf(width));
    }

    /**
     * 获取context
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

}
