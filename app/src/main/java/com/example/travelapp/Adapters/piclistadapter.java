package com.example.travelapp.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travelapp.databinding.ViewhioderpiclistBinding;

import java.util.List;

public class piclistadapter extends RecyclerView.Adapter<piclistadapter.ViewHolder>{


    private List<String>items;
    private ImageView picMain;

    private Context context;
    public piclistadapter(List<String> items, ImageView picMain) {
        this.items = items;
        this.picMain = picMain;
    }


    @NonNull
    @Override
    public piclistadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context=parent.getContext();
        ViewhioderpiclistBinding binding=ViewhioderpiclistBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull piclistadapter.ViewHolder holder, int position) {

        Glide.with(context)
                .load(items.get(position))
                .into(holder.binding.picList);

        holder.binding.getRoot().setOnClickListener(v -> Glide.with(context)
                .load(items.get(position))
                .into(picMain));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewhioderpiclistBinding binding;
        public ViewHolder(ViewhioderpiclistBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}




