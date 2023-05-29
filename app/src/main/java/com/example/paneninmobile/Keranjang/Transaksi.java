package com.example.paneninmobile.Keranjang;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.paneninmobile.Home.BerandaActivity;
import com.example.paneninmobile.R;

public class Transaksi extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioButton radioButton;

    RadioGroup rg;
    RadioButton satu, dua, tiga;
    ImageButton Bayar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaksi);

        rg = (RadioGroup) findViewById(R.id.radio_group);
        satu = (RadioButton) findViewById(R.id.satu);
        dua = (RadioButton) findViewById(R.id.dua);
        tiga = (RadioButton) findViewById(R.id.tiga);
        Bayar = (ImageButton) findViewById(R.id.tombolbayar);
        rg.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);
        Bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Transaksi.this, BerandaActivity.class);
                startActivity(i);
            }
        });

    }




    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.satu) {
            Toast.makeText(this, "Anda memlih COD", Toast.LENGTH_LONG).show();

        }
        if (i == R.id.dua) {
            Toast.makeText(this, "Anda memlih Bank BRI", Toast.LENGTH_LONG).show();

        }
        if (i == R.id.tiga) {
            Toast.makeText(this, "Anda memlih Bank BCA", Toast.LENGTH_LONG).show();

        }

    }


}


