package com.example.administrator.travel_app.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.customizeview.NoScrollViewPager;
import com.example.administrator.travel_app.fragment.MainFragment;
import com.example.administrator.travel_app.fragment.HelpFragment;
import com.example.administrator.travel_app.fragment.MessageFragment;
import com.example.administrator.travel_app.fragment.UserMessageFragment;
import com.example.administrator.travel_app.util.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.ac_main_bottom)
    BottomNavigationView navigation;
    @BindView(R.id.ac_main_viewpager)
    NoScrollViewPager viewPager;

    MainFragment courseFragment;
    HelpFragment helpFragment;
    MessageFragment messageFragment;
    UserMessageFragment userMessageFragment;

    private List<Fragment> fragmentList;
    private FragmentPagerAdapter adapter;

    public static String[] data = new String[] {android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.READ_PHONE_STATE,
            android.Manifest.permission.ACCESS_WIFI_STATE,
            android.Manifest.permission.ACCESS_NETWORK_STATE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.INTERNET,
            android.Manifest.permission.CHANGE_WIFI_STATE,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,data, 1);

        ButterKnife.bind(this);

        init();
        initEvent();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initEvent() {
        viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);

        navigation.setOnNavigationItemSelectedListener(item -> {
            invalidateOptionsMenu();
            switch (item.getItemId()) {
                case R.id.main_menu_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.main_menu_date:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.main_menu_message:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.main_menu_my:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigation.setSelectedItemId(R.id.main_menu_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.main_menu_date);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.main_menu_message);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.main_menu_my);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.i(TAG, "onScrollChange: scrollX = "+scrollX + "  oldScrollX = "+ oldScrollX);
            }
        });
    }

    private void init() {
        fragmentList = new ArrayList<>();
        courseFragment = new MainFragment();
        userMessageFragment = new UserMessageFragment();
        messageFragment = new MessageFragment();
        helpFragment = new HelpFragment();

        fragmentList.add(courseFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(helpFragment);
        fragmentList.add(userMessageFragment);

        BottomNavigationViewHelper.disableShiftMode(navigation);

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }
            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
    }

    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        for(Fragment fragment:fragmentList){
            fragment.onActivityResult(requestCode, resultCode, data);
        }

    }
}
