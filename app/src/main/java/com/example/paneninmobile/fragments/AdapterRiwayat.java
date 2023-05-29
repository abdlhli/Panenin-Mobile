package com.example.paneninmobile.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.Keranjang.KeranjangModel;
import com.example.paneninmobile.R;

import java.util.ArrayList;

public class AdapterRiwayat extends RecyclerView.Adapter<AdapterRiwayat.ViewHolder> {

    private ArrayList<RiwayatModel> riwayatModel;

    public AdapterRiwayat(ArrayList<RiwayatModel> riwayatModel) {
        this.riwayatModel = riwayatModel;
    }

    @NonNull
    @Override
    public AdapterRiwayat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.riwayatcard,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.barangriwayat.setText(riwayatModel.get(position).getbarang());
        holder.idriwayat.setText(riwayatModel.get(position).getid());
        holder.jumlahriwayat.setText(riwayatModel.get(position).getJumlah());
        holder.totalriwayat.setText(riwayatModel.get(position).getTotal());

    }

    @Override
    public int getItemCount() {
        return riwayatModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView barangriwayat, idriwayat, jumlahriwayat, totalriwayat;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            barangriwayat = itemView.findViewById(R.id.riwayatbarang);
            idriwayat = itemView.findViewById(R.id.id_pemesanan);
            jumlahriwayat = itemView.findViewById(R.id.jumlah_barang);
            totalriwayat = itemView.findViewById(R.id.total_barang);


        }
    }
}

