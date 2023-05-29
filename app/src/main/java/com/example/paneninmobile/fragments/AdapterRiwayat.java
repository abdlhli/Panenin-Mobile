package com.example.paneninmobile.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.Keranjang.KeranjangModel;
import com.example.paneninmobile.Models.DetailPemesananModel;
import com.example.paneninmobile.Models.DetailPemesananResponse;
import com.example.paneninmobile.Models.KategoriModel;
import com.example.paneninmobile.Models.PemesananModel;
import com.example.paneninmobile.Models.StatusPemesananModel;
import com.example.paneninmobile.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterRiwayat extends RecyclerView.Adapter<AdapterRiwayat.ViewHolder> {

    private List<PemesananModel> datapemesanan;
    FragmentActivity activity;


    public AdapterRiwayat(FragmentActivity activity, List<PemesananModel> datapemesanan) {
        this.activity = activity;
        this.datapemesanan = datapemesanan;

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
        PemesananModel pemesananmodel = datapemesanan.get(position);
        holder.idriwayat.setText(pemesananmodel.getId_pemesanan());
        holder.barangriwayat.setText(pemesananmodel.getTgl_pemesanan());
        holder.jumlahriwayat.setText(pemesananmodel.getId_status_pemesanan());
        holder.totalriwayat.setText(pemesananmodel.getTotal_harga_pemesanan());

    }

    @Override
    public int getItemCount() {
        return datapemesanan.size();
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

