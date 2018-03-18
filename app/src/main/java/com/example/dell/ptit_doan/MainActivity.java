package com.example.dell.ptit_doan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.developer.nguyenngocbaothy.ptit_project.MonAn;
import com.developer.nguyenngocbaothy.ptit_project.MonAnAdapter;
import com.developer.nguyenngocbaothy.ptit_project.R;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonAn;
    ArrayList<MonAn> arrayMonAn;
    MonAnAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        adapter = new MonAnAdapter(this, R.layout.dong_mon_an, arrayMonAn);
        lvMonAn.setAdapter(adapter);
    }

    private void Anhxa() {
        lvMonAn = (ListView) findViewById(R.id.lvMonAn);
        arrayMonAn = new ArrayList<>();

        arrayMonAn.add(new MonAn("VIET NAM", R.drawable.item_11));
        arrayMonAn.add(new MonAn("MON A", R.drawable.item_14));
        arrayMonAn.add(new MonAn("MON AU", R.drawable.item_16));

    }
}
