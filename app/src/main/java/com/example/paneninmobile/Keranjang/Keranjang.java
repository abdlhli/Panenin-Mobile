package com.example.paneninmobile.Keranjang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.R;

import java.util.ArrayList;

public class Keranjang extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KeranjangAdapter keranjangAdapter;
    private ArrayList<KeranjangModel> keranjangModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_keranjang);

        Button button = findViewById(R.id.button_beli);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Keranjang.this, Transaksi.class);
                startActivity(intent);
            }
        });

        getData();

        recyclerView = findViewById(R.id.recyclerviewkeranjang);
        keranjangAdapter = new KeranjangAdapter(keranjangModels);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Keranjang.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(keranjangAdapter);
    }

    private void getData() {
        keranjangModels = new ArrayList<>();

        keranjangModels.add(new KeranjangModel("20.000", "kentang"));
        keranjangModels.add(new KeranjangModel("30.000", "sawi"));
        keranjangModels.add(new KeranjangModel("40.000", "kubis"));
        keranjangModels.add(new KeranjangModel("50.000", "wortel"));

    }
}
