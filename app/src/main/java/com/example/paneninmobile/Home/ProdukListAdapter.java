package com.example.paneninmobile.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.R;

import java.util.ArrayList;

public class ProdukListAdapter extends RecyclerView.Adapter<ProdukListAdapter.MyHolder> {
    ArrayList<ProdukListGet> dataproduk;

    private Dialog dialog;

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public interface Dialog{
        void onClick(ProdukListGet produkListGet);
    }

    public ProdukListAdapter(ArrayList<ProdukListGet> dataproduk) {

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
        holder.tvTitle3.setText(dataproduk.get(position).getTitle());
        holder.textproduklist.setText(dataproduk.get(position).getHarga());
        holder.gambar.setImageDrawable(dataproduk.get(position).getGambar());
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
