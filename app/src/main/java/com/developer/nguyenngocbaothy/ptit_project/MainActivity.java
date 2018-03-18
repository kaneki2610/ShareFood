package com.developer.nguyenngocbaothy.ptit_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonAn;
    ArrayList<MonAn> arrayMonAn;
    MonAnAdapter adapter;
    Toolbar toolbar;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Anhxa();
         adapter = new MonAnAdapter(this, R.layout.dong_mon_an, arrayMonAn);
         lvMonAn.setAdapter(adapter);
         setSupportActionBar(toolbar);
         getSupportActionBar().setTitle("HÔM NAY ĂN GÌ ?");
         toolbar.setTitleTextColor(Color.WHITE);
         getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         SuKien();
    }

    private void SuKien() {
        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:
                        Intent intentLoaiMon=new Intent(MainActivity.this,LoaiMonAn.class);
                        startActivity(intentLoaiMon);
                        break;

                }
            }
        });
    }

    private void Anhxa() {
        lvMonAn = (ListView) findViewById(R.id.lvMonAn);

        arrayMonAn = new ArrayList<>();

        arrayMonAn.add(new MonAn("VIỆT NAM", R.drawable.item_11));
        arrayMonAn.add(new MonAn("MÓN Á", R.drawable.item_14));
        arrayMonAn.add(new MonAn("MÓN ÂU", R.drawable.item_16));
        arrayMonAn.add(new MonAn("DESSERT", R.drawable.item_11));

        toolbar=findViewById(R.id.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
