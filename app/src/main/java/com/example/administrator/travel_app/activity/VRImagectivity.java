package com.example.administrator.travel_app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.travel_app.R;
import com.zph.glpanorama.GLPanorama;

public class VRImagectivity extends AppCompatActivity {

    GLPanorama panorama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrimagectivity);

        panorama = findViewById(R.id.ac_vr_image);

        panorama.setGLPanorama(R.drawable.quanjing);

    }
}
