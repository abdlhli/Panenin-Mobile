package com.example.paneninmobile.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paneninmobile.R;

import java.util.ArrayList;

public class BelumBayarFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterRiwayat adapterRiwayat;
    private ArrayList<RiwayatModel> riwayatModels;

    public BelumBayarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_belum_bayar, container, false);

        getData();

        recyclerView = view.findViewById(R.id.recyclerviewriwayat);
        adapterRiwayat = new AdapterRiwayat(riwayatModels);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRiwayat);

        return view;
    }

    private void getData() {
        riwayatModels = new ArrayList<>();

        riwayatModels.add(new RiwayatModel("sawi", "kontolbakar", "x1", "21.000"));
        riwayatModels.add(new RiwayatModel("wortel", "memekbosok", "x12", "100.000"));
        riwayatModels.add(new RiwayatModel("brokoli", "halosayang", "x16", "500.000"));
        riwayatModels.add(new RiwayatModel("tempe", "pukimay", "x20", "300.000"));
        riwayatModels.add(new RiwayatModel("tahu", "memekbakar", "x3", "20.000"));
    }
}
