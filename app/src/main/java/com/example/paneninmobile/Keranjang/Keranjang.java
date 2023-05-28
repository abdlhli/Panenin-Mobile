package com.example.paneninmobile.Keranjang;

import android.os.Bundle;

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
