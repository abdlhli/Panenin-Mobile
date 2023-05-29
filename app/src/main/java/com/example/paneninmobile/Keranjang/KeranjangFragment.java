package com.example.paneninmobile.Keranjang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.R;

import java.util.ArrayList;

public class KeranjangFragment extends Fragment {

    private RecyclerView recyclerView;
    private KeranjangAdapter keranjangAdapter;
    private ArrayList<KeranjangModel> keranjangModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keranjang, container, false);

        recyclerView = view.findViewById(R.id.recyclerviewkeranjang);
        keranjangModels = new ArrayList<>();
        keranjangAdapter = new KeranjangAdapter(keranjangModels);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(keranjangAdapter);

        return view;
    }

    public void updateKeranjang(ArrayList<KeranjangModel> keranjangModels) {
        this.keranjangModels = keranjangModels;
        keranjangAdapter.notifyDataSetChanged();
    }
}
