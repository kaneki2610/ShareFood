package com.developer.nguyenngocbaothy.ptit_project;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

/**
 * Created by Dell on 3/11/2018.
 */

public class ProductDetailActivity extends AppCompatActivity {
    Toolbar toolbar;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_layout);
        setTabHost();

        toolbar = findViewById(R.id.toolbarChiTiet);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CHI TIẾT MÓN ĂN ");
        toolbar.setTitleTextColor(Color.BLACK);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    void setTabHost() {
        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("NGUYÊN LIỆU");
        tabSpec1.setIndicator("NGUYÊN LIỆU");

        tabSpec1.setContent(R.id.tab1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("CÁCH NẤU");
        tabSpec2.setIndicator("CÁCH NẤU");
        tabSpec2.setContent(R.id.tab2);

        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("BÌNH LUẬN");
        tabSpec4.setIndicator("BÌNH LUẬN");
        tabSpec4.setContent(R.id.tab3);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("VIDEO");
        tabSpec3.setIndicator("VIDEO");
        tabSpec3.setContent(R.id.tab4);

        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
        tabHost.addTab(tabSpec4);
    }
}
