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
import com.example.paneninmobile.Models.TerlarisModel;
import com.example.paneninmobile.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TerlarisAdapter extends RecyclerView.Adapter<TerlarisAdapter.MyHolder> {
    List<TerlarisModel> data;
    private FragmentActivity activity;

    public TerlarisAdapter(FragmentActivity activity, List<TerlarisModel> data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mostpopularcard, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        TerlarisModel terlarisModel = data.get(position);
        holder.tvTitle2.setText(terlarisModel.getNamaProduk());
        holder.hargaterlaris.setText(terlarisModel.getHargaProduk());

        String imageName = terlarisModel.getFotoProduk();
        String imageUrl = ApiClient.LINK_API + "assets/images/photoproduk/" + imageName;

        Log.d("URL DEBUG FOTO PICASSO", "Image Url:" + imageUrl);
        Picasso.get().load(imageUrl).into(holder.gambarTerpopuler);
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView tvTitle2, hargaterlaris;
        ImageView gambarTerpopuler;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle2 = itemView.findViewById(R.id.tvTitle2);
            hargaterlaris = itemView.findViewById(R.id.hargaterlaris);
            gambarTerpopuler = itemView.findViewById(R.id.gambarTerpopuler);
        }
    }
}
