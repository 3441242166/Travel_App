package com.example.administrator.travel_app.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.administrator.travel_app.R;

public class PopupUtil {

    public static PopupWindow getPopupWindow(Context context, View view) {
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setContentView(view);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    public static PopupWindow getPopupWindow(Context context,View view,int w,int h) {
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setContentView(view);
        popupWindow.setWidth(w);
        popupWindow.setHeight(h);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }
}
