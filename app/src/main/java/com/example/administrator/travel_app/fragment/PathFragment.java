package com.example.administrator.travel_app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.activity.ArticleActivity;
import com.example.administrator.travel_app.activity.HonorActivity;
import com.example.administrator.travel_app.activity.PathMessageActivity;
import com.example.administrator.travel_app.activity.WebActivity;
import com.example.administrator.travel_app.adapter.GridAdapter;
import com.example.administrator.travel_app.adapter.MenuAdapter;
import com.example.administrator.travel_app.adapter.NewsAdapter;
import com.example.administrator.travel_app.adapter.PathAdapter;
import com.example.administrator.travel_app.adapter.TextAdapter;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.NewsBean;
import com.example.administrator.travel_app.bean.PathBean;
import com.example.administrator.travel_app.bean.RecyclerTop;
import com.example.administrator.travel_app.bean.TextBean;
import com.example.administrator.travel_app.util.PagingScrollHelper;

import java.util.ArrayList;

import butterknife.BindView;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static com.example.administrator.travel_app.bean.RecyclerTop.TEXT;
import static com.example.administrator.travel_app.bean.RecyclerTop.TOP;

public class PathFragment extends LazyLoadFragment {
    private static final String TAG = "PathFragment";

    private static final String[] TITLE = {"音乐文化之旅","吃货路线", "情侣路线", "观光路线", "中年路线", "独行路线", "游玩路线"};
    private static final int[] IMG = {R.drawable.view_1_1, R.drawable.view_1_2, R.drawable.view_3_1, R.drawable.view_4_1,R.drawable.view_2_1, R.drawable.view_2_2, R.drawable.view_3_1};
    private static final String[] OTHER_TITLE = {"探索西安", "发现探索夜景", "吃好,玩好一站通", "带着家人一起夜游", "小伙伴路线推荐", "游玩路线", "最魅力西安", "吃货路线", "拍照路线", "散步路线"};
    private static final int[] OTHER_TIMG = {R.drawable.view_4_1, R.drawable.view_4_2, R.drawable.view_3_1, R.drawable.view_2_1,R.drawable.view_2_2,
            R.drawable.view_1_1, R.drawable.view_1_2, R.drawable.view_4_1, R.drawable.view_3_1,R.drawable.view_2_1, R.drawable.view_2_2};

    @BindView(R.id.fg_path_first)
    RecyclerView first;
    @BindView(R.id.fg_path_other)
    RecyclerView other;
    @BindView(R.id.fg_path_menu)
    RecyclerView menu;

    MenuAdapter menuAdapter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_path;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceState) {

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(HORIZONTAL);
        first.setLayoutManager(manager);
        PagingScrollHelper scrollHelper = new PagingScrollHelper();
        scrollHelper.setUpRecycleView(first);
        ArrayList<PathBean> otherList = new ArrayList<>();
        for(int x=0;x<TITLE.length;x++){
            PathBean bean= new PathBean(TITLE[x],IMG[x]);
            otherList.add(bean);
        }
        PathAdapter adapter = new PathAdapter(otherList,getContext());
        adapter.setOnItemClickListener((adapter12, view, position) -> {
            Intent intent = new Intent(getContext(),WebActivity.class);
            intent.putExtra("url","https://baijiahao.baidu.com/s?id=1610377612124959505&wfr=spider&for=pc");
            startActivity(intent);
        });
        first.setAdapter(adapter);
        //------------------------------------------------------------------------------------------

        other.setLayoutManager(new GridLayoutManager(getContext(),2));
        ArrayList<PathBean> newsList = new ArrayList<>();
        for(int x=0;x<OTHER_TITLE.length;x++){
            PathBean bean= new PathBean(OTHER_TITLE[x],OTHER_TIMG[x]);
            newsList.add(bean);
        }
        PathAdapter newsAdapter = new PathAdapter(newsList,getContext());
        other.setAdapter(newsAdapter);
        other.setNestedScrollingEnabled(false);
        newsAdapter.setOnItemClickListener((adapter1, view, position) -> {
            Intent intent = new Intent(getContext(),WebActivity.class);
            intent.putExtra("url","https://baijiahao.baidu.com/s?id=1567818883658472&wfr=spider&for=pc");
            startActivity(intent);
        });
        //------------------------------------------------------------------------------------------
        ArrayList<MultiItemEntity> menuList = new ArrayList<>();
        for(int x=0;x<MENU.length;x++){
            RecyclerTop bean= new RecyclerTop(MENU[x]);
            menuList.add(bean);
            for(int y=0;y<MENU_DATA[x].length;y++){
                TextBean bean_2= new TextBean(MENU_DATA[x][y]);
                menuList.add(bean_2);
            }
        }
        menuAdapter = new MenuAdapter(menuList);
        final GridLayoutManager managers = new GridLayoutManager(getContext(), 3);

        managers.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Log.i(TAG, "getSpanSize: type = "+menuAdapter.getItemViewType(position));
                return menuAdapter.getItemViewType(position) == TOP ? 1 : 3;
            }
        });

        menu.setAdapter(menuAdapter);
        menu.setLayoutManager(managers);
        menu.setNestedScrollingEnabled(false);
        menuAdapter.setOnItemClickListener((adapter1, view, position) -> {
            //Intent intent = new Intent(getContext(),PathMessageActivity.class);
            Intent intent = new Intent(getContext(),HonorActivity.class);
            if(position<5) {
                intent.putExtra("data", position - 1);
                startActivity(intent);
            }else {
                Toast.makeText(getContext(),"正在建设中",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static final String[] MENU = {"夜游主题", "游客特征", "夜游季节", "停留时间","夜游时间"};
    private static final String[][] MENU_DATA = {{"夜颜", "夜演", "夜宴", "夜酽","夜研", "夜验"},
            {"性别", "年龄", "家庭"},
            {"春季", "夏季", "秋季", "冬季"},
            {"一夜游", "二夜游", "三夜游", "多夜游"},
            {"一小时内", "二小时内", "三小时内", "一晚上"}};

}
