package com.example.paneninmobile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.paneninmobile.Home.BerandaFragment;
import com.example.paneninmobile.Keranjang.KeranjangFragment;
import com.example.paneninmobile.Profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottombar);

        bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.HomeButton:
                        selectedFragment = new BerandaFragment();
                        break;
                    case R.id.KeranjangButton:
                        selectedFragment = new KeranjangFragment();
                        break;
                    case R.id.WhatsappButton:
                        openWhatsapp();
                        break;
                    case R.id.ProfileButton:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();
                return true;
            }
        });

        // Set default fragment
        bottomNavigationView.setSelectedItemId(R.id.HomeButton);
    }

    private void openWhatsapp(){
        String phoneNumber = "+6281233326540";
        String message = "Halo, Permisi admin saya ingin menanyakan ";

        try {
            Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + URLEncoder.encode(message, "UTF-8"));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
