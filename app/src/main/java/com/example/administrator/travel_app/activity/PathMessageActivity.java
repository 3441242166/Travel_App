package com.example.administrator.travel_app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.travel_app.R;

public class PathMessageActivity extends AppCompatActivity {

    int[] ar = new int[]{R.string.path_1,R.string.path_2,R.string.path_3,R.string.path_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_message);

        TextView textView = findViewById(R.id.ac_pathmessage_text);
        textView.setText(ar[getIntent().getIntExtra("data",1)]);
    }
}
