package com.example.paneninmobile.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.R;

import java.util.ArrayList;

public class TerlarisAdapter extends RecyclerView.Adapter<TerlarisAdapter.MyHolder> {
    ArrayList<ItemTerlaris> data;

    public TerlarisAdapter(ArrayList<ItemTerlaris> data) {
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
        holder.tvTitle2.setText(data.get(position).getTitle());
        holder.hargaterlaris.setText(data.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView tvTitle2, hargaterlaris;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle2 = itemView.findViewById(R.id.tvTitle2);
            hargaterlaris = itemView.findViewById(R.id.hargaterlaris);
        }
    }
}
