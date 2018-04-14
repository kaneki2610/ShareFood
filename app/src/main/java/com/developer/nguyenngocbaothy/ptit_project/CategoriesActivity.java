package com.developer.nguyenngocbaothy.ptit_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.developer.nguyenngocbaothy.ptit_project.Adapter.CategoryAdapter;
import com.developer.nguyenngocbaothy.ptit_project.Model.Category;
import com.developer.nguyenngocbaothy.ptit_project.Model.Product;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    ListView lvMonAn;
    ArrayList<Category> categoriesList;
    CategoryAdapter adapter;
    Toolbar toolbar;
    DatabaseReference myRef;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);
        Anhxa();

        adapter = new CategoryAdapter(this, R.layout.dong_categories, categoriesList);
        lvMonAn.setAdapter(adapter);
        getCategoriesFirebase();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("HÔM NAY ĂN GÌ ?");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SuKien();
    }

    private void SuKien() {
        /*myRef.child("Products").push().setValue(new Product("0", "-L9xiWYcdCvYYpEKxhHZ", "Mắm chưng", R.drawable.chacalavong_03));
        myRef.child("Products").push().setValue(new Product("1", "-L9xiWYcdCvYYpEKxhHZ", "Bún bò huế", R.drawable.bunbohue_03));
        myRef.child("Products").push().setValue(new Product("2", "-L9xiWYcdCvYYpEKxhHZ", "Bánh hỏi", R.drawable.banhhoi_03));
        myRef.child("Products").push().setValue(new Product("3", "-L9xiWYcdCvYYpEKxhHZ", "Phở gà", R.drawable.banhcanhghe_03));*/
        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentProduct = new Intent(CategoriesActivity.this, ProductsActivity.class);
                intentProduct.putExtra("key", categoriesList.get(i).getId());
                startActivity(intentProduct);
            }
        });
    }

    private void Anhxa() {
        lvMonAn = (ListView) findViewById(R.id.lvMonAn);
        toolbar = findViewById(R.id.toolbar);
        myRef = FirebaseDatabase.getInstance().getReference();
        categoriesList = new ArrayList<>();
    }

    void getCategoriesFirebase() {
        /*myRef.child("Categories").push().setValue(new Category("0", "Món Việt",R.drawable.item_11));
        myRef.child("Categories").push().setValue(new Category("1", "Món Á",R.drawable.item_14));
        myRef.child("Categories").push().setValue(new Category("2", "Món Âu",R.drawable.item_16));
        myRef.child("Categories").push().setValue(new Category("3", "Món tráng miệng",R.drawable.item_03));*/
        myRef.child("Categories").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("getCategoriesFirebase", dataSnapshot.getChildren().toString());
                Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
                for (DataSnapshot item : iterable) {
                    Category cate = item.getValue(Category.class);
                    categoriesList.add(cate);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("getCategoriesFirebase", "Failed to read value.", databaseError.toException());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
