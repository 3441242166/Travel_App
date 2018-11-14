package com.example.administrator.travel_app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.administrator.travel_app.Data;
import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.adapter.ScenceAdapter;
import com.example.administrator.travel_app.bean.ScenceBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.administrator.travel_app.Data.getSearchList;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";

    @BindView(R.id.ac_search_input)
    TextView input;
    @BindView(R.id.ac_search_recycler)
    RecyclerView scence;

    ScenceAdapter scenceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        scence.setLayoutManager(new LinearLayoutManager(this));

        scenceAdapter = new ScenceAdapter(null,this);
        scence.setAdapter(scenceAdapter);
        scence.setNestedScrollingEnabled(false);
        scenceAdapter.setOnItemClickListener((adapter1, view, position) -> {
            Intent intent = new Intent(this,ScenicActivity.class);
            intent.putExtra("data",scenceAdapter.getData().get(position));
            startActivity(intent);
        });




        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged: s = "+s);
                scenceAdapter.setNewData(getSearchList(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    void getData(String str){

    }
}
