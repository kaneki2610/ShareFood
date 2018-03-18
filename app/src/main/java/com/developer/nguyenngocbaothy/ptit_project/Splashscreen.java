package com.developer.nguyenngocbaothy.ptit_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dell on 3/12/2018.
 */

public class Splashscreen extends AppCompatActivity {
    Button btnVaobep,btnDangNhap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        AnhXa();
     //   SuLien();
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);

                }catch (Exception e)
                {

                }finally {
                    Intent intentTrangChu=new Intent(Splashscreen.this,MainActivity.class);
                    startActivity(intentTrangChu);

                }
            }
        });
        t.start();
    }

   /* private void SuLien() {
        btnVaobep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTrangChu=new Intent(Splashscreen.this,MainActivity.class);
                startActivity(intentTrangChu);

            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDangNhap=new Intent(Splashscreen.this,DangNhap.class);
                startActivity(intentDangNhap);

            }
        });
    }*/

    private void AnhXa() {
        btnVaobep=findViewById(R.id.btnVaobep);
        btnDangNhap=findViewById(R.id.btnDangnhap);
    }

}
