package com.developer.nguyenngocbaothy.ptit_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


import com.developer.nguyenngocbaothy.ptit_project.Adapter.ProductAdapter;
import com.developer.nguyenngocbaothy.ptit_project.Model.Product;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 3/12/2018.
 */

public class ProductsActivity extends AppCompatActivity {
    GridView gridView;
    List<Product> productsList;
    ProductAdapter anAdapter;
    Toolbar toolbar;
    DatabaseReference myRef;
    String key;
    private StorageReference mStorageRef;
    Button btnBepchien;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_layout);
        AnhXa();

        key = getIntent().getStringExtra("key");

        anAdapter = new ProductAdapter(ProductsActivity.this, R.layout.dong_products, productsList);
        gridView.setAdapter(anAdapter);
        getProductsFirebase();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MÓN ĂN BA MIỀN");
        toolbar.setTitleTextColor(Color.BLACK);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SuKien();
    }

    private void SuKien() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*Intent detailProductIntent = new Intent(ProductsActivity.this, ProductDetailActivity.class);
                detailProductIntent.putExtra("key", productsList.get(i).getId());
                startActivity(detailProductIntent);*/
            }
        });
        btnBepchien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void AnhXa() {
        gridView = findViewById(R.id.gridview);
        toolbar = findViewById(R.id.toolbarLoaiMonAn);
        productsList = new ArrayList<>();
        myRef = FirebaseDatabase.getInstance().getReference();
        mStorageRef = FirebaseStorage.getInstance().getReference();
        btnBepchien = findViewById(R.id.buttonBepchien);
    }

    private void getProductsFirebase() {
        myRef.child("Products").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
                for (DataSnapshot item : iterable) {
                    Product pd = item.getValue(Product.class);
                    if (pd.getParent_id().equals(key)) {
                        productsList.add(pd);
                        anAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
