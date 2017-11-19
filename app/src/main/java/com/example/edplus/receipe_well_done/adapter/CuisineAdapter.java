package com.example.edplus.receipe_well_done.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edplus.receipe_well_done.R;
import com.example.edplus.receipe_well_done.listener.CustomOnItemClickListener;

import java.util.ArrayList;


public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineListViewHolder> {

    Context context;
    ArrayList<String> charityUsersList;
    ArrayList<Integer> imageIdList;
    CustomOnItemClickListener customOnItemClickListener;

    public CuisineAdapter(Context context, ArrayList<String> charityUsersList, ArrayList<Integer> imageIdList, CustomOnItemClickListener customOnItemClickListener) {
        this.context = context;
        this.charityUsersList = charityUsersList;
        this.imageIdList = imageIdList;
        this.customOnItemClickListener = customOnItemClickListener;
    }


    @Override
    public CuisineListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cuisine, parent, false);
        CuisineListViewHolder holder = new CuisineListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CuisineListViewHolder holder, final int position) {
        String userName = charityUsersList.get(position);
        holder.cuisineTV.setText(userName);
        int imageId = imageIdList.get(position);
        holder.cuisineIV.setImageResource(imageId);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customOnItemClickListener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return charityUsersList.size();
    }

    public class CuisineListViewHolder extends RecyclerView.ViewHolder {
        TextView cuisineTV;
        ImageView cuisineIV;
        View itemView;

        public CuisineListViewHolder(View itemView) {
            super(itemView);
            cuisineTV = (TextView) itemView.findViewById(R.id.cuisineTV);
            cuisineIV = (ImageView) itemView.findViewById(R.id.cuisineIV);
            this.itemView = itemView;
        }
    }
}

