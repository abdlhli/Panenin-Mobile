package com.example.paneninmobile.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paneninmobile.MainActivity;
import com.example.paneninmobile.R;


public class UpdateProfileActivity extends AppCompatActivity {
    Button btn_bekbek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubahprofile);

        btn_bekbek = findViewById(R.id.btnBck);

        btn_bekbek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}