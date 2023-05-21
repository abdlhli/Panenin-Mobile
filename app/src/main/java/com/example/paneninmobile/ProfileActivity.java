package com.example.paneninmobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    Button btn_edit;
    TextView btn_pesanan;
    Button btn_pesanan2;
    Button btn_belum_bayar;
    Button btn_dikemas;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btn_edit= findViewById(R.id.btnEdit);
        btn_pesanan = findViewById(R.id.btnRiwayat);
        btn_pesanan2 = findViewById(R.id.btnRiwayat2);
        btn_belum_bayar = findViewById(R.id.btnBelumbayar);
        btn_dikemas = findViewById(R.id.btnDikemas);



        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, UpdateProfileActivity.class));
            }
        });

        btn_pesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailRiwayatActivity.class);
                startActivity(intent);
            }
        });
        btn_pesanan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailRiwayatActivity.class);
                startActivity(intent);
            }
        });
        btn_belum_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailRiwayatActivity.class);
                startActivity(intent);
            }
        });
        btn_dikemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailRiwayatActivity.class);

                startActivity(intent);
            }
        });
    }
}