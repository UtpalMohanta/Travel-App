package com.example.travelapp.Adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travelapp.DetailActivity;
import com.example.travelapp.ModelClass.ItemModel;
import com.example.travelapp.databinding.ViewHolderpopularBinding;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    private Context context;
    private final List<ItemModel>item;

    public PopularAdapter(List<ItemModel> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        ViewHolderpopularBinding binding=ViewHolderpopularBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel items=item.get(position);
        holder.binding.textTitle.setText(items.getTitle());
        holder.binding.textNight.setText("$"+items.getPrice()+"/Night");
        holder.binding.textAddress.setText(items.getAddress());
        holder.binding.textRating.setText(""+items.getScore());

        Glide.with(context)
                .load(items.getPic().get(0))
                .into(holder.binding.pic1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("itemModel",item.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewHolderpopularBinding binding;
        public ViewHolder(ViewHolderpopularBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
