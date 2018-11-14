package com.example.administrator.travel_app.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.adapter.GridAdapter;
import com.example.administrator.travel_app.adapter.NormalAdapter;
import com.example.administrator.travel_app.adapter.PagerAdapter;
import com.example.administrator.travel_app.base.BaseApplication;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.NormalBean;
import com.example.administrator.travel_app.bean.ScenceBean;
import com.example.administrator.travel_app.config.ApiConstant;
import com.example.administrator.travel_app.fragment.IntroduceFragment;
import com.example.administrator.travel_app.fragment.RemarkFragment;
import com.example.administrator.travel_app.fragment.StrategyFragment;
import com.example.administrator.travel_app.util.BDLocationUtils;
import com.example.administrator.travel_app.util.ImageLoader;
import com.example.administrator.travel_app.util.MyItemDecoration;
import com.example.administrator.travel_app.util.MyLocationListener;
import com.example.administrator.travel_app.util.PopupUtil;
import com.example.administrator.travel_app.util.SaveDataUtil;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.administrator.travel_app.config.ApiConstant.SCREEN_HEIGHT;

public class ScenicActivity extends AppCompatActivity {
    private static final String TAG = "ScenicActivity";

    @BindView(R.id.fg_scenic_banner)
    Banner banner;
    @BindView(R.id.fg_scenic_name)
    TextView name;
    @BindView(R.id.fg_scenic_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.fg_scenic_menu)
    RecyclerView recyclerMenu;
    @BindView(R.id.fg_scenic_tablayout)
    TabLayout tabLayout ;
    @BindView(R.id.fg_scenic_viewpager)
    ViewPager viewPager;
    @BindView(R.id.fg_scenic_describe)
    TextView describe;

    private List<Fragment> fragmentList;
    ScenceBean scenceBean;

    private static final String[] MENU_TITLE = {"夜间出行", "夜间餐饮", "夜间购物", "夜间休闲","夜间住宿", "全景VR", "夜间安全", "便民服务"};
    private static final int[] MENU_IMG = {R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh,R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh};
    private static final String[] OTHER_TITLE = {"地理位置", "营业时间", "联系电话", "门票价格"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenic);
        ButterKnife.bind(this);

        scenceBean = (ScenceBean) getIntent().getSerializableExtra("data");
        init();
        //viewPager.setMinimumHeight(Integer.valueOf(SaveDataUtil.getValueFromSharedPreferences(this,SCREEN_HEIGHT)) - tabLayout.getHeight());
        BDLocationUtils bdLocationUtils = new BDLocationUtils(this);
        bdLocationUtils.doLocation();//开启定位
        bdLocationUtils.mLocationClient.start();//开始定位

    }

    private void init() {
        name.setText(scenceBean.getTitle());
        describe.setText(scenceBean.getDescribe());

        List<Integer> list = new ArrayList<>();
        for(int id:scenceBean.getImgID()){
            list.add(id);
        }
        banner.setImageLoader(new ImageLoader());
        banner.setImages(list);
        banner.start();

        //------------------------------------------------------------------------------------------

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new MyItemDecoration());
        ArrayList<NormalBean> otherList = new ArrayList<>();

        for(int x=0;x<OTHER_TITLE.length;x++){
            NormalBean bean = null;
            switch (x){
                case 0:
                    bean= new NormalBean(OTHER_TITLE[x],scenceBean.getPosition());
                    break;
                case 1:
                    bean= new NormalBean(OTHER_TITLE[x],scenceBean.getTime());
                    break;
                case 2:
                    bean= new NormalBean(OTHER_TITLE[x],scenceBean.getPhone());
                    break;
                case 3:
                    bean= new NormalBean(OTHER_TITLE[x],scenceBean.getPrice());
                    break;
            }
            otherList.add(bean);
        }

        NormalAdapter adapter = new NormalAdapter(otherList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            Intent i1 = new Intent();
            String url = "http://api.map.baidu.com/direction?origin="+ ApiConstant.LATITUDE+","+ApiConstant.LONGITUDE+"&destination="+scenceBean.getLocation()+"&mode=driving&src=andr.baidu.openAPIdemo&output=html";
            Log.i(TAG, "openDialog: url = "+url);
            i1.setData(Uri.parse(url));
            startActivity(i1);
        });
        //------------------------------------------------------------------------------------------

        fragmentList = new ArrayList<>();
        fragmentList.add(new IntroduceFragment());
        fragmentList.add(new StrategyFragment());
        fragmentList.add(new RemarkFragment());
        String []ar ={"介绍","攻略","评论"};
        viewPager.setAdapter(new PagerAdapter<>(getSupportFragmentManager(), fragmentList, ar));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPager.setOffscreenPageLimit(3);

        //------------------------------------------------------------------------------------------

        recyclerMenu.setLayoutManager(new GridLayoutManager(this, 4));
        ArrayList<GridBean> menuList = new ArrayList<>();
        for(int x = 0; x< MENU_TITLE.length; x++){
            GridBean bean= new GridBean(MENU_IMG[x], MENU_TITLE[x]);
            menuList.add(bean);
        }
        GridAdapter menuAdapter = new GridAdapter(menuList,this);
        recyclerMenu.setAdapter(menuAdapter);
        recyclerMenu.setNestedScrollingEnabled(false);

        menuAdapter.setOnItemClickListener((adapter12, view, position) -> {
            if(position == 5){
                Toast.makeText(this,"暂时未获得该地区的VR资源",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ScenicActivity.this,VRImagectivity.class));
                return;
            }
            openDialog(position);
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) viewPager.getLayoutParams();
        //获取当前控件的布局对象
        Log.i(TAG, "onCreate: tablayout height = "+tabLayout.getHeight());
        params.height= Integer.valueOf(SaveDataUtil.getValueFromSharedPreferences(this,SCREEN_HEIGHT)) - tabLayout.getHeight() -(int)Math.ceil(25 * getResources().getDisplayMetrics().density);//设置当前控件布局的高度
        viewPager.setLayoutParams(params);//将设置好的布局参数应用到控件中
    }

    private static final String[] TITLE_1 = {"地铁站", "公交车", "出租车", "快车", "共享单车", "停车场", "加油站","充电桩"};
    private static final String[] TITLE_2 = {"中餐", "西餐", "快餐", "清真", "羊肉泡馍", "肉夹馍", "葫芦头"};
    private static final String[] TITLE_3 = {"商场", "超市", "书店"};
    private static final String[] TITLE_4 = {"景点", "电影院", "网吧", "书店", "酒吧", "KTV", "咖啡店","表演"};
    private static final String[] TITLE_5 = {"酒店", "旅馆"};
    private static final String[] TITLE_6 = {"演出", "表演"};
    private static final String[] TITLE_7 = {"派出所", "公安局"};
    private static final String[] TITLE_8 = {"医院", "公共厕所","便利店"};
    private static final String[][] TITLES= {TITLE_1,TITLE_2,TITLE_3,TITLE_4,TITLE_5,TITLE_6,TITLE_7,TITLE_8};
    private static final int[] FOOT_IMG = {R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh, R.mipmap.gv_section, R.mipmap.gv_empty, R.mipmap.gv_drag_and_swipe,R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh, R.mipmap.gv_section, R.mipmap.gv_empty, R.mipmap.gv_drag_and_swipe};


    protected void openDialog(int pos){
        //显示PopupWindow
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_course_more, null);
        final PopupWindow popupWindow = PopupUtil.getPopupWindow(this,view);
        //设置点击事件
        RecyclerView recyclerView = view.findViewById(R.id.dialog_course_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        ArrayList<GridBean> otherList = new ArrayList<>();

        for(int x=0;x<TITLES[pos].length;x++){
            GridBean bean= new GridBean(FOOT_IMG[x],TITLES[pos][x]);
            otherList.add(bean);
        }

        GridAdapter adapter = new GridAdapter(otherList,this);
        adapter.setOnItemClickListener((adapter1, view1, position) -> {
            Intent i1 = new Intent();
            String url = "http://api.map.baidu.com/place/search?query="+adapter.getData().get(position).getName()+"&location="+scenceBean.getLocation()+"&radius=1000&src=andr.baidu.openAPIdemo&output=html";
            Log.i(TAG, "openDialog: url = "+url);
            i1.setData(Uri.parse(url));
            startActivity(i1);
            popupWindow.dismiss();
        });
        recyclerView.setAdapter(adapter);
        View parent = LayoutInflater.from(this).inflate(R.layout.activity_scenic, null);
        //显示PopupWindow
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
    }

}
