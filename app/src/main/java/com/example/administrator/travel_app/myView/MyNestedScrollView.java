package com.example.administrator.travel_app.myView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyNestedScrollView extends NestedScrollView {
    private static final String TAG = "MyNestedScrollView";

    boolean isInner = false;

    public MyNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public MyNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = super.onInterceptTouchEvent(ev);

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                //判断MOVE的方向

                //如果父Layout不可以继续下滑
                Log.i(TAG, "onInterceptTouchEvent: canScrollVertically =" + canScrollVertically(1));
                if(canScrollVertically(1)){
                    intercepted = true;
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean result = super.onTouchEvent(ev);

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                //判断MOVE的方向

                //如果父Layout不可以继续下滑
                Log.i(TAG, "onInterceptTouchEvent: canScrollVertically =" + canScrollVertically(1));
                if(canScrollVertically(1)){
                    result = true;
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return result;
    }
}
