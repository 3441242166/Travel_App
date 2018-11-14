package com.example.administrator.travel_app.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.administrator.travel_app.R;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView = findViewById(R.id.ac_webview);

        webView.loadUrl(getIntent().getStringExtra("url"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setUseWideViewPort(true); // 关键点
        webView.getSettings().setAllowFileAccess(true); // 允许访问文件
        webView.getSettings().setSupportZoom(true); // 支持缩放
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE); // 不加载缓存内容
    }
}
