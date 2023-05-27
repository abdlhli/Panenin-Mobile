package com.example.paneninmobile.Home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.Api.ApiClient;
import com.example.paneninmobile.Models.ProdukModel;
import com.example.paneninmobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProdukListAdapter extends RecyclerView.Adapter<ProdukListAdapter.MyHolder> {
    ArrayList<ProdukModel> dataproduk;

    private Dialog dialog;

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public interface Dialog{
        void onClick(ProdukModel ProdukModel);
    }

    public ProdukListAdapter(ArrayList<ProdukModel> dataproduk) {

        this.dataproduk = dataproduk;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produklistcard, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        ProdukModel produk = dataproduk.get(position);
        holder.tvTitle3.setText(produk.getNamaProduk());
        holder.textproduklist.setText(produk.getHargaProduk());

        String imageName = produk.getFotoProduk();
        String imageUrl = ApiClient.LINK_API + "assets/images/photoproduk/" + imageName;

        Log.d("URL DEBUG FOTO PICASSO", "Image Url:" + imageUrl);
        Picasso.get().load(imageUrl).into(holder.gambar);
    }

    @Override
    public int getItemCount() {

        return dataproduk.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView tvTitle3, textproduklist;
        ImageView gambar;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle3 = itemView.findViewById(R.id.tvTitle3);
            textproduklist = itemView.findViewById(R.id.textproduklist);
            gambar = itemView.findViewById(R.id.Produklist);

            itemView.setOnClickListener(v -> {
                if (dialog!=null){
                    dialog.onClick(dataproduk.get(getLayoutPosition()));

                }
            });
        }
    }
}
