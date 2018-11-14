package com.example.administrator.travel_app.fragment;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.bean.ScenceBean;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

import static com.example.administrator.travel_app.config.Constant.ScenceID;
import static com.example.administrator.travel_app.config.Constant.scenceUrl;

public class IntroduceFragment extends LazyLoadFragment {
    private static final String TAG = "IntroduceFragment";

    @BindView(R.id.audio_play)
    ImageView play;
    @BindView(R.id.audio_stop)
    ImageView stop;
    @BindView(R.id.audio_seekbar)
    SeekBar seekBar;
    @BindView(R.id.fg_introduce_introduce)
    WebView webView;

    MediaPlayer mMediaPlayer;
    boolean playIng = false;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            seekBar.setProgress(msg.what);
            super.handleMessage(msg);
        }
    };
    MediaThread thread = new MediaThread();

    @Override
    protected int setContentView() {
        return R.layout.fragment_introduce;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void lazyLoad(Bundle savedInstanceState) {
        mMediaPlayer= MediaPlayer.create(getContext(), R.raw.media);

        Log.i(TAG, "lazyLoad: time = "+mMediaPlayer.getDuration());
        seekBar.setMax(mMediaPlayer.getDuration());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(scenceUrl[ScenceID]);

        initEvent();
    }

    private void initEvent() {
        play.setOnClickListener(v -> {
            if(!playIng) {
                Log.i(TAG, "lazyLoad: start");
                mMediaPlayer.start();
                playIng = true;
                play.setImageResource(android.R.drawable.ic_media_pause);
                thread = new MediaThread();
                thread.start();
            }
            else {
                Log.i(TAG, "lazyLoad: pause");
                mMediaPlayer.pause();
                playIng = false;
                play.setImageResource(android.R.drawable.ic_media_play);
                thread.interrupt();
            }
        });

        stop.setOnClickListener(v -> {
            Log.i(TAG, "lazyLoad: stop");
            mMediaPlayer.stop();
            playIng = false;
            mMediaPlayer= MediaPlayer.create(getContext(), R.raw.media);
            play.setImageResource(android.R.drawable.ic_media_play);
            seekBar.setProgress(0);
            thread.interrupt();
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mMediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void load(){

    }

    @Override
    public void onStop() {
        super.onStop();
        thread.interrupt();
        if(null!=mMediaPlayer) {
            mMediaPlayer.stop();
        }
    }

    class MediaThread extends Thread{

        @Override
        public void run() {
            super.run();
            while (true) {
                Log.i(TAG, "start: sendPos = " + mMediaPlayer.getCurrentPosition());
                handler.sendEmptyMessage(mMediaPlayer.getCurrentPosition());
                if(isInterrupted()){
                    return;
                }
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
