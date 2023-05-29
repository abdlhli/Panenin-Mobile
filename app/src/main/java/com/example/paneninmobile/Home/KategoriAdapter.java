package com.example.paneninmobile.Home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.Api.ApiClient;
import com.example.paneninmobile.Models.KategoriModel;
import com.example.paneninmobile.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.CustomViewHolder> {
    private List<KategoriModel> data;
    private FragmentActivity activity;

    public KategoriAdapter(FragmentActivity activity, List<KategoriModel> data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategoricard, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        KategoriModel kategoriResponse = data.get(position);
        holder.tvTitle.setText(kategoriResponse.getNama_jenis_produk());

        String imageName = kategoriResponse.getFoto_jenis_produk();
        String imageUrl = ApiClient.LINK_API + "assets/images/photojenisproduk/" + imageName;

        Log.d("URL DEBUG FOTO PICASSO", "Image Url:" + imageUrl);
        Picasso.get().load(imageUrl).into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivFoto;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivFoto = itemView.findViewById(R.id.ivFoto);
        }
    }
}