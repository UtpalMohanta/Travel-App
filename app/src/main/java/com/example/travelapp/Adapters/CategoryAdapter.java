package com.example.travelapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travelapp.ModelClass.CategoryModel;
import com.example.travelapp.databinding.ViewHolderBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private final List<CategoryModel>items;
     private Context context;
    public CategoryAdapter(List<CategoryModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        ViewHolderBinding binding=ViewHolderBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {

        CategoryModel item=items.get(position);
        holder.binding.textCate.setText(item.getName());

        Glide.with(context)
                .load(item.getImagePath())
                .into(holder.binding.ImageCate);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewHolderBinding binding;

        public ViewHolder(ViewHolderBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
