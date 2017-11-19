package com.example.edplus.receipe_well_done.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.edplus.receipe_well_done.MainActivity;
import com.example.edplus.receipe_well_done.R;
import com.example.edplus.receipe_well_done.adapter.CuisineAdapter;
import com.example.edplus.receipe_well_done.adapter.ReceipeAdapter;
import com.example.edplus.receipe_well_done.listener.CustomOnItemClickListener;

import java.util.ArrayList;

public class ReceipeListActivity extends AppCompatActivity {

    private RecyclerView receipeRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipe__list);

        receipeRV = (RecyclerView)findViewById(R.id.receipeRV);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        receipeRV.setLayoutManager(gridLayoutManager);

        ArrayList<String> stringArrayList = new ArrayList<String>();
        // stringArrayList.add("American");
        stringArrayList.add("Pav Bhaji ");
        stringArrayList.add("Masala Dosa");
        stringArrayList.add("Pasta");
        stringArrayList.add("Pani Puri");

        ArrayList<Integer> imageId = new ArrayList<Integer>();
        // imageId.add(R.mipmap.american);
        imageId.add(R.mipmap.indian);
        imageId.add(R.mipmap.mexican);
        imageId.add(R.mipmap.italian);
        imageId.add(R.mipmap.mediterranean);

        CustomOnItemClickListener onItemClickListener = new CustomOnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent reciepeIntent = new Intent(ReceipeListActivity.this, ReceipeDetailsActivity.class);
                startActivity(reciepeIntent);
            }
        };

        ReceipeAdapter receipeAdapter = new ReceipeAdapter(this, stringArrayList, imageId, onItemClickListener);
        receipeRV.setAdapter(receipeAdapter);


    }
    }

