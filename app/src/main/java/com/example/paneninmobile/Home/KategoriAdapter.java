package com.example.paneninmobile.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paneninmobile.R;

import java.util.ArrayList;

public  class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.MyHolder>{
    ArrayList<String> data;
    public KategoriAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategoricard,null, false);
        return new  MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvTitle.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends  RecyclerView.ViewHolder{
        TextView tvTitle;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
