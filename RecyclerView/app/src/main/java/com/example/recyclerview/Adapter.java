package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.VHolder> {

    String[] data;

    public Adapter(String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, int position) {
        holder.textView.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class VHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public VHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}