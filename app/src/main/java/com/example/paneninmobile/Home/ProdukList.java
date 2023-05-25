package com.example.paneninmobile.Home;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.R;

import java.util.ArrayList;

public class ProdukList extends AppCompatActivity {

    private RecyclerView recyclerViewProdukList;

    private ProdukListAdapter produkListAdapter;

    private ArrayList<ProdukListGet> dataSourceProdukList = new ArrayList<>();
    ArrayList<ProdukListGet> dataProdukList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.produklist);
        recyclerViewProdukList = findViewById(R.id.horizontalRv3);

        dataProdukList.add(new ProdukListGet("Judul 1", "Harga 1"));
        dataProdukList.add(new ProdukListGet("Judul 2", "Harga 2"));
        dataProdukList.add(new ProdukListGet("Judul 3", "Harga 3"));
        dataProdukList.add(new ProdukListGet("Judul 4", "Harga 4"));
        dataProdukList.add(new ProdukListGet("Judul 5", "Harga 5"));
        dataProdukList.add(new ProdukListGet("Judul 6", "Harga 6"));
        dataProdukList.add(new ProdukListGet("Judul 7", "Harga 7"));
        dataProdukList.add(new ProdukListGet("Judul 8", "Harga 8"));
        dataProdukList.add(new ProdukListGet("Judul 9", "Harga 9"));

        dataSourceProdukList.addAll(dataProdukList);



        ProdukListAdapter produkListAdapter = new ProdukListAdapter(dataSourceProdukList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerViewProdukList.setLayoutManager(layoutManager);
        recyclerViewProdukList.setAdapter(produkListAdapter);

        produkListAdapter.setDialog(new ProdukListAdapter.Dialog() {
            @Override
            public void onClick(ProdukListGet produkListGet) {
                Toast.makeText(getApplicationContext(), "Kamu klik menu : " +produkListGet.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });





    }
}
