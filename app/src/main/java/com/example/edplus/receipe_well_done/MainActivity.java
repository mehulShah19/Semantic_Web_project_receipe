package com.example.edplus.receipe_well_done;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

import com.example.edplus.receipe_well_done.activity.ReceipeDetailsActivity;
import com.example.edplus.receipe_well_done.activity.ReceipeListActivity;
import com.example.edplus.receipe_well_done.adapter.CuisineAdapter;
import com.example.edplus.receipe_well_done.listener.CustomOnItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView cuiseneRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cuiseneRV = (RecyclerView)findViewById(R.id.cuisineRV);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        cuiseneRV.setLayoutManager(gridLayoutManager);

        ArrayList<String> stringArrayList = new ArrayList<String>();
       // stringArrayList.add("American");
        stringArrayList.add("Indian");
        stringArrayList.add("Mexican");
        stringArrayList.add("Italian");
        stringArrayList.add("Mediterranean");

        ArrayList<Integer> imageId = new ArrayList<Integer>();
       // imageId.add(R.mipmap.american);
        imageId.add(R.mipmap.indian);
        imageId.add(R.mipmap.mexican);
        imageId.add(R.mipmap.italian);
        imageId.add(R.mipmap.mediterranean);

        CustomOnItemClickListener onItemClickListener = new CustomOnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent reciepeIntent = new Intent(MainActivity.this, ReceipeListActivity.class);
                startActivity(reciepeIntent);
            }
        };

        CuisineAdapter cuisineAdapter = new CuisineAdapter(this, stringArrayList, imageId, onItemClickListener);
        cuiseneRV.setAdapter(cuisineAdapter);


    }

}
