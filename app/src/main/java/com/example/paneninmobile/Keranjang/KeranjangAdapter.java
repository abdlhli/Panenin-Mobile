package com.example.paneninmobile.Keranjang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.R;

import java.util.ArrayList;

public class KeranjangAdapter extends RecyclerView.Adapter<KeranjangAdapter.ViewHolder> {

    private ArrayList<KeranjangModel> keranjangModels;

    public KeranjangAdapter(ArrayList<KeranjangModel> keranjangModels) {
        this.keranjangModels = keranjangModels;
    }

    @NonNull
    @Override
    public KeranjangAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.keranjangcard,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KeranjangAdapter.ViewHolder holder, int position) {
        holder.hargakeranjang.setText(keranjangModels.get(position).getHarga());
        holder.barangkeranjang.setText(keranjangModels.get(position).getbarang());

    }

    @Override
    public int getItemCount() {
        return keranjangModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView hargakeranjang, barangkeranjang;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hargakeranjang = itemView.findViewById(R.id.harga_keranjang);
            barangkeranjang = itemView.findViewById(R.id.barangnya);


        }
    }
}
