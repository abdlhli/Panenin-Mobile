package com.example.paneninmobile.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.paneninmobile.Api.ApiClient;
import com.example.paneninmobile.Api.ApiService;
import com.example.paneninmobile.Home.KategoriAdapter;
import com.example.paneninmobile.Models.KategoriModel;
import com.example.paneninmobile.Models.KategoriResponse;
import com.example.paneninmobile.Models.PemesananModel;
import com.example.paneninmobile.Models.PemesananResponse;
import com.example.paneninmobile.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BelumBayarFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterRiwayat adapterRiwayat;
    private List<PemesananModel> pemesananModels;

    public BelumBayarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_belum_bayar, container, false);

//        getData();

//        recyclerView = view.findViewById(R.id.recyclerviewriwayat);
//        adapterRiwayat = new AdapterRiwayat(riwayatModels);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapterRiwayat);

        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<PemesananResponse> call = service.getAllPemesanan();
        call.enqueue(new Callback<PemesananResponse>() {
            @Override
            public void onResponse(Call<PemesananResponse> call, Response<PemesananResponse> response) {

                if (response.isSuccessful()) {
                    PemesananResponse PemesananResponse = response.body();
                    if (PemesananResponse != null) {
                        List<PemesananModel> pemesananModelList = PemesananResponse.getData();
                        Log.d("API Response", "Data berhasil diambil: " + pemesananModelList.toString());
                        generatePemesananList(pemesananModelList);
                    }
                } else {
                    String errorMessage = "Error: " + response.code() + " - " + response.message();
                    Log.e("API Response", errorMessage);
                }
            }

            @Override
            public void onFailure(Call<PemesananResponse> call, Throwable t) {
                Log.e("ErrorAPI", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    private void generatePemesananList(List<PemesananModel> pemesananModelList) {
        recyclerView = getView().findViewById(R.id.recyclerviewriwayat);
        AdapterRiwayat adapter = new AdapterRiwayat(getActivity(), pemesananModelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

//    private void getData() {
//        riwayatModels = new ArrayList<>();
//
//        riwayatModels.add(new RiwayatModel("sawi", "kontolbakar", "x1", "21.000"));
//        riwayatModels.add(new RiwayatModel("wortel", "memekbosok", "x12", "100.000"));
//        riwayatModels.add(new RiwayatModel("brokoli", "halosayang", "x16", "500.000"));
//        riwayatModels.add(new RiwayatModel("tempe", "pukimay", "x20", "300.000"));
//        riwayatModels.add(new RiwayatModel("tahu", "memekbakar", "x3", "20.000"));
//    }
}
