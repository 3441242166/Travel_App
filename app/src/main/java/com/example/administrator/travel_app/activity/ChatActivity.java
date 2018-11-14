package com.example.administrator.travel_app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.adapter.ChatAdapter;
import com.example.administrator.travel_app.adapter.NormalAdapter;
import com.example.administrator.travel_app.bean.ChatBean;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatActivity extends AppCompatActivity {
    @BindView(R.id.ac_course_list)
    RecyclerView recyclerView;
    @BindView(R.id.ac_course_send)
    Button send;
    @BindView(R.id.ac_course_input)
    MaterialEditText editText;

    List<ChatBean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ChatAdapter adapter = new ChatAdapter(data,this);
        recyclerView.setAdapter(adapter);

        send.setOnClickListener(v -> {
            data.add(new ChatBean(editText.getText().toString()));
            adapter.setNewData(data);
            editText.setText("");
        });
    }
}
