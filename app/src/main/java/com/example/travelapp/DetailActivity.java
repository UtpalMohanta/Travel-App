package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.travelapp.Adapters.piclistadapter;
import com.example.travelapp.ModelClass.ItemModel;
import com.example.travelapp.databinding.ActivityDetailBinding;

import java.util.ArrayList;

public class DetailActivity extends BaseActivity {

    ActivityDetailBinding binding;
    private ItemModel itemModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setvariable();
        initList();
    }

    private void initList() {

        ArrayList<String>picList=new ArrayList<>(itemModel.getPic());
        Glide.with(this)
                .load(picList.get(0))
                .into(binding.pic);


        binding.picList.setAdapter(new piclistadapter(picList,binding.pic));
        binding.picList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void setvariable() {
        binding.tit.setText(itemModel.getTitle());
        binding.nightdo.setText("$" + itemModel.getPrice());
        binding.bacImg.setOnClickListener(v -> finish());
        binding.bad.setText("" + itemModel.getBed());
        binding.duration.setText(itemModel.getDuration());
        binding.distance.setText(itemModel.getDistance());
        binding.discription.setText(itemModel.getDescription());
        binding.title.setText(itemModel.getAddress());
        binding.rattext.setText(itemModel.getScore()+" Rating");
        binding.rat.setRating((float) itemModel.getScore());
    }

    private void getIntentExtra() {
        itemModel=(ItemModel) getIntent().getSerializableExtra("itemModel");
    }
}