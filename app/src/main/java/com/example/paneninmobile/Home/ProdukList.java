package com.example.paneninmobile.Home;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.Api.ApiClient;
import com.example.paneninmobile.Api.ApiService;
import com.example.paneninmobile.Models.ProdukModel;
import com.example.paneninmobile.Models.ProdukResponse;
import com.example.paneninmobile.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdukList extends AppCompatActivity {

    private RecyclerView recyclerViewProdukList;

    private ProdukListAdapter produkListAdapter;

    private ArrayList<ProdukModel> dataSourceProdukList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produklist);
        recyclerViewProdukList = findViewById(R.id.horizontalRv3);

        //Kategori
        // Create handle for the RetrofitInstance interface
        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<ProdukResponse> call = service.getAllProduk();
        call.enqueue(new Callback<ProdukResponse>() {
            @Override
            public void onResponse(Call<ProdukResponse> call, Response<ProdukResponse> response) {

                if (response.isSuccessful()) {
                    ProdukResponse produkResponse = response.body();
                    if (produkResponse != null) {
                        List<ProdukModel> produkModelList = produkResponse.getData();
                        Log.d("API Response", "Data berhasil diambil: " + produkModelList.toString());
                        generateDataList(produkModelList);
                    }
                } else {
                    String errorMessage = "Error: " + response.code() + " - " + response.message();
                    Log.e("API Response", errorMessage);
                }
            }

            @Override
            public void onFailure(Call<ProdukResponse> call, Throwable t) {
                Log.e("ErrorAPI", "onFailure: " + t.getMessage());
            }
        });
    }

    private void generateDataList(List<ProdukModel> produkModelList) {
        dataSourceProdukList.addAll(produkModelList);
        produkListAdapter = new ProdukListAdapter(dataSourceProdukList);
        LinearLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerViewProdukList.setLayoutManager(layoutManager);
        recyclerViewProdukList.setAdapter(produkListAdapter);

        produkListAdapter.setDialog(new ProdukListAdapter.Dialog() {
            @Override
            public void onClick(ProdukModel produkModel) {
                Toast.makeText(getApplicationContext(), "Kamu menambahkan: " + produkModel.getNamaProduk() + " Ke Keranjang", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
