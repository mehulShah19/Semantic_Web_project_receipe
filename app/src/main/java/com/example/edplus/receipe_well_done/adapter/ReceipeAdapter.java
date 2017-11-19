package com.example.edplus.receipe_well_done.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edplus.receipe_well_done.R;
import com.example.edplus.receipe_well_done.listener.CustomOnItemClickListener;

import java.util.ArrayList;


public class ReceipeAdapter extends RecyclerView.Adapter<ReceipeAdapter.ReceipeListViewHolder> {

    Context context;
    ArrayList<String> charityUsersList;
    ArrayList<Integer> imageIdList;
    CustomOnItemClickListener customOnItemClickListener;

    public ReceipeAdapter(Context context, ArrayList<String> charityUsersList, ArrayList<Integer> imageIdList, CustomOnItemClickListener customOnItemClickListener) {
        this.context = context;
        this.charityUsersList = charityUsersList;
        this.imageIdList = imageIdList;
        this.customOnItemClickListener = customOnItemClickListener;
    }


    @Override
    public ReceipeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_receipe, parent, false);
        ReceipeListViewHolder holder = new ReceipeListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ReceipeListViewHolder holder, final int position) {
        String userName = charityUsersList.get(position);
        holder.receipeNameTV.setText(userName);
        int imageId = imageIdList.get(position);
        holder.receipeIV.setImageResource(imageId);

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

    public class ReceipeListViewHolder extends RecyclerView.ViewHolder {
        TextView receipeRating;
        TextView receipeNameTV;
        TextView receipeIngredientTV;
        ImageView receipeIV;
        View itemView;

        public ReceipeListViewHolder(View itemView) {
            super(itemView);
            receipeRating = (TextView) itemView.findViewById(R.id.receipeRating);
            receipeNameTV = (TextView) itemView.findViewById(R.id.receipeNameTV);
            receipeIngredientTV = (TextView) itemView.findViewById(R.id.receipeIngredientTV);
            receipeIV = (ImageView) itemView.findViewById(R.id.receipeIV);
            this.itemView = itemView;
        }
    }
}

