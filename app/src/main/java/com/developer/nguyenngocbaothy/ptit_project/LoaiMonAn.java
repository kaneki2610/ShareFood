package com.developer.nguyenngocbaothy.ptit_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.developer.nguyenngocbaothy.ptit_project.Adapter.CustomLoaiMonAnAdapter;
import com.developer.nguyenngocbaothy.ptit_project.Model.MonAnModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 3/12/2018.
 */

public class LoaiMonAn extends AppCompatActivity {
    GridView gridView;
    List<MonAnModel>ds;
    CustomLoaiMonAnAdapter anAdapter;
  Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monan_theoloai);
        AnhXa();
        SuKien();
    }

    private void SuKien() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==5)
                {
                    Intent intentLoaiMon=new Intent(LoaiMonAn.this,ChiTietMonAn.class);
                    startActivity(intentLoaiMon);
                }
            }
        });
    }

    @SuppressLint("RestrictedApi")
    private void AnhXa() {
        gridView=findViewById(R.id.gridview);
        toolbar=findViewById(R.id.toolbarLoaiMonAn);
        ds=new ArrayList<>();
        ReadData();
        anAdapter=new CustomLoaiMonAnAdapter(LoaiMonAn.this,R.layout.dong_loaimon,ds);
        gridView.setAdapter(anAdapter);
        anAdapter.notifyDataSetChanged();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MÓN ĂN 3 MIỀN");
        toolbar.setTitleTextColor(Color.BLACK);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void ReadData() {
        MonAnModel m1=new MonAnModel();
        m1.setHinhAnh(R.drawable.mamchung_03);
        m1.setTenMon("Mắm chung");
        ds.add(m1);

        MonAnModel m2=new MonAnModel();
        m2.setHinhAnh(R.drawable.chacalavong_03);
        m2.setTenMon("Chả cá võng");
        ds.add(m2);

        MonAnModel m3=new MonAnModel();
        m3.setHinhAnh(R.drawable.bunbohue_03);
        m3.setTenMon("Bún bò huế");
        ds.add(m3);

        MonAnModel m4=new MonAnModel();
        m4.setHinhAnh(R.drawable.banhhoi_03);
        m4.setTenMon("Bánh hỏi");
        ds.add(m4);

        MonAnModel m5=new MonAnModel();
        m5.setHinhAnh(R.drawable.banhcanhghe_03);
        m5.setTenMon("Bánh canh ghe");
        ds.add(m5);

        MonAnModel m6=new MonAnModel();
        m6.setHinhAnh(R.drawable.pho_03);
        m6.setTenMon("Phở gà");
        ds.add(m6);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
